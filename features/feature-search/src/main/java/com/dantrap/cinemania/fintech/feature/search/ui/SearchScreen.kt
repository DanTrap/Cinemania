package com.dantrap.cinemania.fintech.feature.search.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.core.ui.components.AppendState
import com.dantrap.cinemania.fintech.core.ui.components.MovieItem
import com.dantrap.cinemania.fintech.core.ui.components.RefreshState
import com.dantrap.cinemania.fintech.feature.search.composables.SearchTopBar
import com.dantrap.cinemania.fintech.feature.search.state.SearchEvent
import com.dantrap.cinemania.fintech.feature.search.state.SearchState
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    state: SearchState,
    modifier: Modifier = Modifier,
    onEvent: (SearchEvent) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { SearchTopBar(scrollBehavior = scrollBehavior, state = state, onEvent = onEvent) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = padding.calculateTopPadding())
        ) {
            when {
                state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

                state.movies != null -> SearchScreenContent(state.movies, onEvent = onEvent)
            }
        }
    }
}

@Composable
private fun SearchScreenContent(
    moviesFlow: Flow<PagingData<Movie>>,
    onEvent: (SearchEvent) -> Unit,
) {
    val movies = moviesFlow.collectAsLazyPagingItems()
    Box {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.Top)
        ) {
            items(count = movies.itemCount) { index ->
                movies[index]?.let { movie ->
                    MovieItem(
                        movie = movie,
                        onClick = { onEvent(SearchEvent.OnMovieClick(movie.kinopoiskId)) },
                        onLongClick = { onEvent(SearchEvent.OnMovieLongClick(movie)) }
                    )
                }
            }
            item {
                AppendState(
                    append = movies.loadState.append,
                    isListEmpty = movies.itemCount == 0,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    movies.retry()
                }
            }
        }
        RefreshState(
            modifier = Modifier.align(Alignment.Center),
            refresh = movies.loadState.refresh,
            isListEmpty = movies.itemCount == 0,
            errorMessage = stringResource(R.string.connection_lost),
            onRetry = { movies.retry() }
        )
    }
}

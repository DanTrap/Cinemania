package com.dantrap.cinemania.fintech.feature.favorite.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.core.ui.components.MovieItem
import com.dantrap.cinemania.fintech.feature.favorite.composables.EmptyFavoritesDatabase
import com.dantrap.cinemania.fintech.feature.favorite.composables.FavoriteTopBar
import com.dantrap.cinemania.fintech.feature.favorite.state.FavoriteEvent
import com.dantrap.cinemania.fintech.feature.favorite.state.FavoriteState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(
    state: FavoriteState,
    modifier: Modifier = Modifier,
    onEvent: (FavoriteEvent) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { FavoriteTopBar(scrollBehavior = scrollBehavior, onEvent = onEvent) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = padding.calculateTopPadding())
        ) {
            when {
                state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

                state.movies.isEmpty() -> EmptyFavoritesDatabase(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 16.dp)
                )

                else -> FavoriteScreenContent(state, onEvent = onEvent)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun FavoriteScreenContent(state: FavoriteState, onEvent: (FavoriteEvent) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 16.dp, alignment = Alignment.Top)
    ) {
        items(state.movies) { movie ->
            MovieItem(
                movie = movie,
                modifier = Modifier.animateItemPlacement(),
                onClick = { onEvent(FavoriteEvent.OnMovieClick(movie.kinopoiskId)) },
                onLongClick = { onEvent(FavoriteEvent.OnMovieLongClick(movie.kinopoiskId)) }
            )
        }
    }
}

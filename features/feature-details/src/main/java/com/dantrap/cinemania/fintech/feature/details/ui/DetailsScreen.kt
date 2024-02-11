package com.dantrap.cinemania.fintech.feature.details.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dantrap.cinemania.fintech.core.domain.model.MovieDetails
import com.dantrap.cinemania.fintech.core.ui.components.ErrorDialog
import com.dantrap.cinemania.fintech.feature.details.composables.DetailsTopBar
import com.dantrap.cinemania.fintech.feature.details.composables.MovieDetails
import com.dantrap.cinemania.fintech.feature.details.state.DetailsEvent
import com.dantrap.cinemania.fintech.feature.details.state.DetailsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    state: DetailsState,
    onEvent: (DetailsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            DetailsTopBar(
                scrollBehavior = scrollBehavior,
                onNavigateBack = { onEvent(DetailsEvent.OnBackArrowClick) }
            )
        }
    ) { padding ->
        padding.calculateTopPadding()
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            when {
                state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

                state.movieDetails != null -> DetailsScreenContent(state.movieDetails)

                state.error != null -> ErrorDialog(
                    error = state.error,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    onEvent(DetailsEvent.OnRetryClick)
                }
            }
        }
    }
}

@Composable
private fun DetailsScreenContent(movieDetails: MovieDetails) {
    Box {
        val screenHeight = LocalConfiguration.current.screenHeightDp
        AsyncImage(
            model = movieDetails.posterUrl,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeight * 0.7).dp),
            contentDescription = null
        )
        Surface(color = Color.Transparent) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((screenHeight * 0.5).dp),
                        color = Color.Black.copy(alpha = 0.2f)
                    ) {}
                }
                item {
                    MovieDetails(movieDetails = movieDetails)
                }
            }
        }
    }
}

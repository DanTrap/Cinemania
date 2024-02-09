package com.dantrap.cinemania.fintech.feature.home.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.core.ui.components.ProgressLottieAnimation
import com.dantrap.cinemania.fintech.feature.home.presentation.composables.HomeTopBar
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeEvent
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(state: HomeState, modifier: Modifier = Modifier, onEvent: (HomeEvent) -> Unit) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { HomeTopBar(scrollBehavior = scrollBehavior, onEvent = onEvent) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (state.isLoading) {
                true -> ProgressLottieAnimation(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(200.dp),
                    rawAnimId = R.raw.lottie_ball_animation
                )

                else -> HomeScreenContent()
            }
        }
    }
}

@Composable
private fun HomeScreenContent() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.Top
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    HomeScreen(HomeState(isLoading = false)) {}
}

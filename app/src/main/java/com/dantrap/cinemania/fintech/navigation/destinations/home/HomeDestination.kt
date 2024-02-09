package com.dantrap.cinemania.fintech.navigation.destinations.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.dantrap.cinemania.fintech.core.ui.components.LockScreenOrientation
import com.dantrap.cinemania.fintech.feature.home.presentation.HomeViewModel
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeSideEffect
import com.dantrap.cinemania.fintech.feature.home.presentation.ui.HomeScreen
import com.dantrap.cinemania.fintech.navigation.destinations.Destination
import com.dantrap.cinemania.fintech.utils.composable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

fun NavGraphBuilder.homeDestination(navController: NavController) {
    composable(destination = Destination.AppGraph.Home) {
        val viewModel = koinViewModel<HomeViewModel>()
        val state = viewModel.collectAsState().value

        HomeScreen(state = state, onEvent = viewModel::onEvent)
        LockScreenOrientation()

        viewModel.collectSideEffect {
            when (it) {
                HomeSideEffect.NavigateToSettings -> navController.navigate(
                    Destination.AppGraph.SettingsGraph()
                )
            }
        }
    }
}

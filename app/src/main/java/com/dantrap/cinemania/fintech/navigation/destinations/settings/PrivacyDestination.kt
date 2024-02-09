package com.dantrap.cinemania.fintech.navigation.destinations.settings

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.dantrap.cinemania.fintech.feature.settings.privacy.PrivacyViewModel
import com.dantrap.cinemania.fintech.feature.settings.privacy.states.PrivacySideEffect
import com.dantrap.cinemania.fintech.feature.settings.privacy.ui.PrivacyScreen
import com.dantrap.cinemania.fintech.utils.Destination
import com.dantrap.cinemania.fintech.utils.composable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

fun NavGraphBuilder.privacyDestination(navController: NavController) {
    composable(destination = Destination.AppGraph.SettingsGraph.Privacy) {
        val viewModel = koinViewModel<PrivacyViewModel>()
        val state = viewModel.collectAsState().value

        PrivacyScreen(state = state, onEvent = viewModel::onEvent)

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                PrivacySideEffect.NavigateBack -> navController.navigateUp()
            }
        }
    }
}

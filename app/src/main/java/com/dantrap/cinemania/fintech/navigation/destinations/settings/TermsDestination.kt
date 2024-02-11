package com.dantrap.cinemania.fintech.navigation.destinations.settings

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.dantrap.cinemania.fintech.feature.settings.terms.TermsViewModel
import com.dantrap.cinemania.fintech.feature.settings.terms.states.TermsSideEffect
import com.dantrap.cinemania.fintech.feature.settings.terms.ui.TermsScreen
import com.dantrap.cinemania.fintech.utils.Destination
import com.dantrap.cinemania.fintech.utils.composable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

fun NavGraphBuilder.termsDestination(navController: NavController) {
    composable(destination = Destination.AppGraph.SettingsGraph.Terms) {
        val viewModel = koinViewModel<TermsViewModel>()
        val state = viewModel.collectAsState().value

        TermsScreen(state = state, onEvent = viewModel::onEvent)

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                TermsSideEffect.NavigateBack -> navController.navigateUp()
            }
        }
    }
}

package com.dantrap.cinemania.fintech.navigation.destinations.settings

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.dantrap.cinemania.fintech.feature.settings.menu.SettingsViewModel
import com.dantrap.cinemania.fintech.feature.settings.menu.states.SettingsSideEffect
import com.dantrap.cinemania.fintech.feature.settings.menu.ui.SettingsScreen
import com.dantrap.cinemania.fintech.utils.Destination
import com.dantrap.cinemania.fintech.utils.composable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectSideEffect

fun NavGraphBuilder.settingsDestination(
    navController: NavController,
    stubNavController: NavController,
) {
    composable(destination = Destination.AppGraph.SettingsGraph.Settings) {
        val viewModel = koinViewModel<SettingsViewModel>()

        SettingsScreen(onEvent = viewModel::onEvent)

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                SettingsSideEffect.NavigateBack -> stubNavController.navigateUp()

                SettingsSideEffect.NavigateToLanguages -> navController.navigate(
                    Destination.AppGraph.SettingsGraph.Language()
                )

                SettingsSideEffect.NavigateToPrivacyPolicy -> navController.navigate(
                    Destination.AppGraph.SettingsGraph.Privacy()
                )

                SettingsSideEffect.NavigateToTerms -> navController.navigate(
                    Destination.AppGraph.SettingsGraph.Terms()
                )
            }
        }
    }
}

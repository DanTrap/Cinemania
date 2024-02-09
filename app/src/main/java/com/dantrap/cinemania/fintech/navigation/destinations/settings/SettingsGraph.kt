package com.dantrap.cinemania.fintech.navigation.destinations.settings

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.feature.settings.language.LanguageViewModel
import com.dantrap.cinemania.fintech.feature.settings.language.states.LanguageEvent
import com.dantrap.cinemania.fintech.feature.settings.language.states.LanguageSideEffect
import com.dantrap.cinemania.fintech.feature.settings.language.ui.LanguageScreen
import com.dantrap.cinemania.fintech.feature.settings.menu.SettingsViewModel
import com.dantrap.cinemania.fintech.feature.settings.menu.states.SettingsSideEffect
import com.dantrap.cinemania.fintech.feature.settings.menu.ui.SettingsScreen
import com.dantrap.cinemania.fintech.feature.settings.privacy.PrivacyViewModel
import com.dantrap.cinemania.fintech.feature.settings.privacy.states.PrivacySideEffect
import com.dantrap.cinemania.fintech.feature.settings.privacy.ui.PrivacyScreen
import com.dantrap.cinemania.fintech.feature.settings.terms.TermsViewModel
import com.dantrap.cinemania.fintech.feature.settings.terms.states.TermsSideEffect
import com.dantrap.cinemania.fintech.feature.settings.terms.ui.TermsScreen
import com.dantrap.cinemania.fintech.navigation.destinations.Destination
import com.dantrap.cinemania.fintech.utils.composable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

fun NavGraphBuilder.settingsGraph(stubNavController: NavController) {
    composable(destination = Destination.AppGraph.SettingsGraph) {
        val settingsNavController = rememberNavController()
        NavHost(
            navController = settingsNavController,
            startDestination = Destination.AppGraph.SettingsGraph.Settings()
        ) {
            settingsDestination(settingsNavController, stubNavController)
            languageDestination(settingsNavController)
            privacyDestination(settingsNavController)
            termsDestination(settingsNavController)
        }
    }
}

private fun NavGraphBuilder.settingsDestination(
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

private fun NavGraphBuilder.languageDestination(navController: NavController) {
    composable(destination = Destination.AppGraph.SettingsGraph.Language) {
        val viewModel = koinViewModel<LanguageViewModel>()
        val state = viewModel.collectAsState().value

        val mapLocales = mapOf(
            R.string.en to "en",
        ).mapKeys { stringResource(it.key) }

        LaunchedEffect(key1 = true) {
            viewModel.onEvent(LanguageEvent.FetchAvailableLocales(mapLocales))
        }

        LanguageScreen(state = state, onEvent = viewModel::onEvent)

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                LanguageSideEffect.NavigateBack -> navController.navigateUp()
            }
        }
    }
}

private fun NavGraphBuilder.privacyDestination(navController: NavController) {
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

private fun NavGraphBuilder.termsDestination(navController: NavController) {
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

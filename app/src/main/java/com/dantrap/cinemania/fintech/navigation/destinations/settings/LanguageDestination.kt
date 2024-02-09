package com.dantrap.cinemania.fintech.navigation.destinations.settings

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.feature.settings.language.LanguageViewModel
import com.dantrap.cinemania.fintech.feature.settings.language.states.LanguageEvent
import com.dantrap.cinemania.fintech.feature.settings.language.states.LanguageSideEffect
import com.dantrap.cinemania.fintech.feature.settings.language.ui.LanguageScreen
import com.dantrap.cinemania.fintech.utils.Destination
import com.dantrap.cinemania.fintech.utils.composable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

fun NavGraphBuilder.languageDestination(navController: NavController) {
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

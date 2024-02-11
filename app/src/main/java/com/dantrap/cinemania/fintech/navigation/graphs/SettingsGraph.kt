package com.dantrap.cinemania.fintech.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dantrap.cinemania.fintech.navigation.destinations.settings.languageDestination
import com.dantrap.cinemania.fintech.navigation.destinations.settings.privacyDestination
import com.dantrap.cinemania.fintech.navigation.destinations.settings.settingsDestination
import com.dantrap.cinemania.fintech.navigation.destinations.settings.termsDestination
import com.dantrap.cinemania.fintech.utils.Destination
import com.dantrap.cinemania.fintech.utils.composable

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

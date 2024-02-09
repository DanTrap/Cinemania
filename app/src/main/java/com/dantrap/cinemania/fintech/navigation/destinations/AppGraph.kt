package com.dantrap.cinemania.fintech.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.dantrap.cinemania.fintech.navigation.destinations.home.homeDestination
import com.dantrap.cinemania.fintech.navigation.destinations.settings.settingsGraph

fun NavGraphBuilder.appGraph(outerNavController: NavController) {
    navigation(
        startDestination = Destination.AppGraph.Home(),
        route = Destination.AppGraph()
    ) {
        homeDestination(outerNavController)
        settingsGraph(outerNavController)
    }
}

package com.dantrap.cinemania.fintech.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.dantrap.cinemania.fintech.utils.Destination

fun NavGraphBuilder.appGraph(outerNavController: NavController) {
    navigation(
        startDestination = BOTTOM_BAR_GRAPH_ROUTE,
        route = Destination.AppGraph()
    ) {
        bottomBarGraph(outerNavController)
        settingsGraph(outerNavController)
    }
}

package com.dantrap.cinemania.fintech.navigation.graphs

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dantrap.cinemania.fintech.composables.CinemaniaBottomBar
import com.dantrap.cinemania.fintech.navigation.destinations.favorite.favoriteDestination
import com.dantrap.cinemania.fintech.navigation.destinations.home.homeDestination
import com.dantrap.cinemania.fintech.navigation.destinations.search.searchDestination
import com.dantrap.cinemania.fintech.utils.CustomNavHost
import com.dantrap.cinemania.fintech.utils.Destination

const val BOTTOM_BAR_GRAPH_ROUTE = "GRAPH_ROUTE"

fun NavGraphBuilder.bottomBarGraph(outerNavController: NavController) {
    composable(route = BOTTOM_BAR_GRAPH_ROUTE) {
        val bottomBarNavController = rememberNavController()
        Scaffold(
            bottomBar = { CinemaniaBottomBar(navController = bottomBarNavController) }
        ) { padding ->
            padding.calculateBottomPadding()
            CustomNavHost(
                modifier = Modifier.padding(bottom = padding.calculateBottomPadding()),
                navController = bottomBarNavController,
                startDestination = Destination.AppGraph.Home,
            ) {
                homeDestination(outerNavController)
                favoriteDestination(outerNavController)
                searchDestination(outerNavController)
            }
        }
    }
}

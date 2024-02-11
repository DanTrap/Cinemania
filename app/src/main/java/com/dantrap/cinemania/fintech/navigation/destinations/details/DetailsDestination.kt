package com.dantrap.cinemania.fintech.navigation.destinations.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.dantrap.cinemania.fintech.feature.details.DetailsViewModel
import com.dantrap.cinemania.fintech.feature.details.state.DetailsSideEffect
import com.dantrap.cinemania.fintech.feature.details.ui.DetailsScreen
import com.dantrap.cinemania.fintech.utils.Destination
import com.dantrap.cinemania.fintech.utils.composable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

fun NavGraphBuilder.detailsDestination(navController: NavController) {
    composable(
        destination = Destination.AppGraph.Details,
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    ) { entry ->
        val id = entry.arguments?.getInt("id") ?: 0
        val viewModel = koinViewModel<DetailsViewModel>(parameters = { parametersOf(id) })
        val state = viewModel.collectAsState().value

        DetailsScreen(state = state, onEvent = viewModel::onEvent)

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                DetailsSideEffect.NavigateBack -> navController.navigateUp()
            }
        }
    }
}

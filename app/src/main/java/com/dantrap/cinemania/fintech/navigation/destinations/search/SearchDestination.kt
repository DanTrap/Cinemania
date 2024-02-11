package com.dantrap.cinemania.fintech.navigation.destinations.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.dantrap.cinemania.fintech.feature.search.SearchViewModel
import com.dantrap.cinemania.fintech.feature.search.state.SearchSideEffect
import com.dantrap.cinemania.fintech.feature.search.ui.SearchScreen
import com.dantrap.cinemania.fintech.utils.Destination
import com.dantrap.cinemania.fintech.utils.composable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

fun NavGraphBuilder.searchDestination(navController: NavController) {
    composable(destination = Destination.AppGraph.Search) {
        val viewModel = koinViewModel<SearchViewModel>()
        val state = viewModel.collectAsState().value

        SearchScreen(state = state, onEvent = viewModel::onEvent)

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                is SearchSideEffect.NavigateToMovie -> navController.navigate(
                    Destination.AppGraph.Details(sideEffect.id)
                )
            }
        }
    }
}

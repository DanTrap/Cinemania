package com.dantrap.cinemania.fintech.navigation.destinations.favorite

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.dantrap.cinemania.fintech.feature.favorite.FavoriteViewModel
import com.dantrap.cinemania.fintech.feature.favorite.state.FavoriteSideEffect
import com.dantrap.cinemania.fintech.feature.favorite.ui.FavoriteScreen
import com.dantrap.cinemania.fintech.utils.Destination
import com.dantrap.cinemania.fintech.utils.composable
import org.koin.androidx.compose.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

fun NavGraphBuilder.favoriteDestination(navController: NavController) {
    composable(destination = Destination.AppGraph.Favorite) {
        val viewModel = koinViewModel<FavoriteViewModel>()
        val state = viewModel.collectAsState().value

        FavoriteScreen(state = state, onEvent = viewModel::onEvent)

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                is FavoriteSideEffect.NavigateToMovieDetails -> navController.navigate(
                    Destination.AppGraph.Details(sideEffect.id)
                )

                FavoriteSideEffect.NavigateToSettings -> navController.navigate(
                    Destination.AppGraph.SettingsGraph()
                )
            }
        }
    }
}

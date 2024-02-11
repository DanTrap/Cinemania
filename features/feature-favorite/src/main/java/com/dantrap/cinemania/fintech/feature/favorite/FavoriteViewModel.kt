package com.dantrap.cinemania.fintech.feature.favorite

import androidx.lifecycle.viewModelScope
import com.dantrap.cinemania.fintech.core.domain.usecase.GetFavoriteMovieUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.RemoveMovieFromFavoriteUseCase
import com.dantrap.cinemania.fintech.core.mvi.BaseViewModel
import com.dantrap.cinemania.fintech.feature.favorite.state.FavoriteEvent
import com.dantrap.cinemania.fintech.feature.favorite.state.FavoriteSideEffect
import com.dantrap.cinemania.fintech.feature.favorite.state.FavoriteState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class FavoriteViewModel(
    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase,
    private val removeMovieFromFavoriteUseCase: RemoveMovieFromFavoriteUseCase,
) : BaseViewModel<FavoriteState, FavoriteSideEffect, FavoriteEvent>(initialState = FavoriteState()) {

    init {
        onEvent(FavoriteEvent.LoadFavoriteMovies)
    }

    override fun onEvent(event: FavoriteEvent) {
        when (event) {
            FavoriteEvent.LoadFavoriteMovies -> loadMovies()
            FavoriteEvent.OnSettingsClick -> navigateToSettings()
            is FavoriteEvent.OnMovieClick -> navigateToMovie(event.id)
            is FavoriteEvent.OnMovieLongClick -> removeFromFavorite(event.id)
        }
    }

    private fun loadMovies() {
        intent {
            getFavoriteMovieUseCase().onEach { movies ->
                reduce { state.copy(isLoading = false, movies = movies) }
            }.launchIn(viewModelScope)
        }
    }

    private fun removeFromFavorite(id: Int) {
        intent { removeMovieFromFavoriteUseCase(id) }
    }

    private fun navigateToMovie(id: Int) {
        intent { postSideEffect(FavoriteSideEffect.NavigateToMovieDetails(id)) }
    }

    private fun navigateToSettings() {
        intent { postSideEffect(FavoriteSideEffect.NavigateToSettings) }
    }
}

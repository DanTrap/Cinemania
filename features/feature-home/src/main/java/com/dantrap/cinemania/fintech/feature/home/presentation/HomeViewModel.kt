package com.dantrap.cinemania.fintech.feature.home.presentation

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.dantrap.cinemania.fintech.core.domain.usecase.GetMoviesUseCase
import com.dantrap.cinemania.fintech.core.mvi.BaseViewModel
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeEvent
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeSideEffect
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeState
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class HomeViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
) : BaseViewModel<HomeState, HomeSideEffect, HomeEvent>(
    initialState = HomeState()
) {

    init {
        onEvent(HomeEvent.LoadMovies)
    }

    override fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.LoadMovies -> loadMovies()
            HomeEvent.OnSettingsClick -> navigateToSettings()
            is HomeEvent.OnMovieClick -> navigateToMovie(event.id)
            is HomeEvent.OnMovieLongClick -> addMovieToFavorite(event.id)
        }
    }

    private fun addMovieToFavorite(id: Int) {}

    private fun navigateToMovie(id: Int) {
        intent { postSideEffect(HomeSideEffect.NavigateToMovie(id)) }
    }

    private fun loadMovies() {
        intent {
            val movies = getMoviesUseCase().cachedIn(viewModelScope)
            reduce { state.copy(movies = movies, isLoading = false) }
        }
    }

    private fun navigateToSettings() {
        intent { postSideEffect(HomeSideEffect.NavigateToSettings) }
    }
}

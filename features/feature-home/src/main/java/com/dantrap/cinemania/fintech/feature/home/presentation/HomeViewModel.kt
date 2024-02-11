package com.dantrap.cinemania.fintech.feature.home.presentation

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.domain.usecase.AddMovieToFavoriteUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.GetFavoriteMovieUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.GetMoviesUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.RemoveMovieFromFavoriteUseCase
import com.dantrap.cinemania.fintech.core.mvi.BaseViewModel
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeEvent
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeSideEffect
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeState
import kotlinx.coroutines.flow.combine
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class HomeViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val addMovieToFavoriteUseCase: AddMovieToFavoriteUseCase,
    private val removeMovieFromFavoriteUseCase: RemoveMovieFromFavoriteUseCase,
    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase,
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
            is HomeEvent.OnMovieLongClick -> onLongClick(event.movie)
        }
    }

    private fun onLongClick(movie: Movie) {
        intent {
            if (movie.isFavorite) {
                removeMovieFromFavoriteUseCase(movie.kinopoiskId)
            } else {
                addMovieToFavoriteUseCase(movie)
            }
        }
    }

    private fun navigateToMovie(id: Int) {
        intent { postSideEffect(HomeSideEffect.NavigateToMovie(id)) }
    }

    private fun loadMovies() {
        intent {
            val movies = getMoviesUseCase().cachedIn(viewModelScope)
                .combine(getFavoriteMovieUseCase()) { movies, favorites ->
                    movies.map { movie ->
                        if (favorites.map { it.kinopoiskId }.contains(movie.kinopoiskId)) {
                            movie.copy(isFavorite = true)
                        } else {
                            movie.copy(isFavorite = false)
                        }
                    }
                }.cachedIn(viewModelScope)
            reduce { state.copy(movies = movies, isLoading = false) }
        }
    }

    private fun navigateToSettings() {
        intent { postSideEffect(HomeSideEffect.NavigateToSettings) }
    }
}

package com.dantrap.cinemania.fintech.feature.home.presentation.states

import androidx.compose.runtime.Immutable
import com.dantrap.cinemania.fintech.core.domain.model.Movie

@Immutable
sealed class HomeEvent {
    data object LoadMovies : HomeEvent()
    data object OnSettingsClick : HomeEvent()
    data class OnMovieClick(val id: Int) : HomeEvent()
    data class OnMovieLongClick(val movie: Movie) : HomeEvent()
}

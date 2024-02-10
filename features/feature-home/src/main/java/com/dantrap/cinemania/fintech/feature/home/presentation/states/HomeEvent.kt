package com.dantrap.cinemania.fintech.feature.home.presentation.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class HomeEvent {
    data object LoadMovies : HomeEvent()
    data object OnSettingsClick : HomeEvent()
    data class OnMovieClick(val id: Int) : HomeEvent()
    data class OnMovieLongClick(val id: Int) : HomeEvent()
}

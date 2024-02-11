package com.dantrap.cinemania.fintech.feature.favorite.state

import androidx.compose.runtime.Immutable

@Immutable
sealed class FavoriteEvent {
    data object LoadFavoriteMovies : FavoriteEvent()
    data object OnSettingsClick : FavoriteEvent()
    data class OnMovieClick(val id: Int) : FavoriteEvent()
    data class OnMovieLongClick(val id: Int) : FavoriteEvent()
}

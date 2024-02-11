package com.dantrap.cinemania.fintech.feature.favorite.state

import androidx.compose.runtime.Immutable

@Immutable
sealed class FavoriteSideEffect {
    data object NavigateToSettings : FavoriteSideEffect()
    data class NavigateToMovieDetails(val id: Int) : FavoriteSideEffect()
}

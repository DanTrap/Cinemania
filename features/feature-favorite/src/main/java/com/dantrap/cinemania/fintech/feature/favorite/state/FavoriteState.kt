package com.dantrap.cinemania.fintech.feature.favorite.state

import androidx.compose.runtime.Immutable
import com.dantrap.cinemania.fintech.core.domain.model.Movie

@Immutable
data class FavoriteState(
    val isLoading: Boolean = true,
    val movies: List<Movie> = emptyList()
)

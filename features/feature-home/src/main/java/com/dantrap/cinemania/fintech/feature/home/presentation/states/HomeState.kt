package com.dantrap.cinemania.fintech.feature.home.presentation.states

import androidx.compose.runtime.Immutable
import androidx.paging.PagingData
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

@Immutable
data class HomeState(
    val isLoading: Boolean = true,
    val movies: Flow<PagingData<Movie>>? = null,
)

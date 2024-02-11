package com.dantrap.cinemania.fintech.feature.search.state

import androidx.compose.runtime.Immutable
import androidx.paging.PagingData
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

@Immutable
data class SearchState(
    val isLoading: Boolean = false,
    val query: String = "",
    val movies: Flow<PagingData<Movie>>? = null,
    val isSearchActive: Boolean = false
)

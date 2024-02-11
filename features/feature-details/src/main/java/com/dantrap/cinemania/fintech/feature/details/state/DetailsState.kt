package com.dantrap.cinemania.fintech.feature.details.state

import androidx.compose.runtime.Immutable
import com.dantrap.cinemania.fintech.core.common.network.ResponseError
import com.dantrap.cinemania.fintech.core.domain.model.MovieDetails

@Immutable
data class DetailsState(
    val isLoading: Boolean = true,
    val movieDetails: MovieDetails? = null,
    val error: ResponseError? = null
)

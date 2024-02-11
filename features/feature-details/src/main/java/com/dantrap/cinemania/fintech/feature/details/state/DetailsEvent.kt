package com.dantrap.cinemania.fintech.feature.details.state

import androidx.compose.runtime.Immutable

@Immutable
sealed class DetailsEvent {
    data class LoadMovieDetails(val id: Int) : DetailsEvent()
    data object OnBackArrowClick : DetailsEvent()
    data object OnRetryClick : DetailsEvent()
}

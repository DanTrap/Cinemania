package com.dantrap.cinemania.fintech.feature.search.state

import androidx.compose.runtime.Immutable
import com.dantrap.cinemania.fintech.core.domain.model.Movie

@Immutable
sealed class SearchEvent {
    data class OnMovieClick(val id: Int) : SearchEvent()
    data class OnMovieLongClick(val movie: Movie) : SearchEvent()
    data class OnUserInput(val text: String) : SearchEvent()
    data class OnSearch(val text: String) : SearchEvent()
}

package com.dantrap.cinemania.fintech.feature.search.state

import androidx.compose.runtime.Immutable

@Immutable
sealed class SearchSideEffect {
    data class NavigateToMovie(val id: Int) : SearchSideEffect()
}

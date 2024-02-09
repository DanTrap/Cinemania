package com.dantrap.cinemania.fintech.feature.settings.terms.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class TermsSideEffect {
    data object NavigateBack : TermsSideEffect()
}

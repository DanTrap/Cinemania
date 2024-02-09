package com.dantrap.cinemania.fintech.feature.home.presentation.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class HomeSideEffect {
    data object NavigateToSettings : HomeSideEffect()
}

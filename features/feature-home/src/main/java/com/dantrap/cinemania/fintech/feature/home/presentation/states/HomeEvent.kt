package com.dantrap.cinemania.fintech.feature.home.presentation.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class HomeEvent {
    data object ObserveLanguage : HomeEvent()
    data object OnSettingsClick : HomeEvent()
}

package com.dantrap.cinemania.fintech.feature.settings.menu.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class SettingsSideEffect {
    data object NavigateBack : SettingsSideEffect()
    data object NavigateToPrivacyPolicy : SettingsSideEffect()
    data object NavigateToLanguages : SettingsSideEffect()
    data object NavigateToTerms : SettingsSideEffect()
}

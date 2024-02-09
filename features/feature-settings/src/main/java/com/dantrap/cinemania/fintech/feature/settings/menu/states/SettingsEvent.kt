package com.dantrap.cinemania.fintech.feature.settings.menu.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class SettingsEvent {
    data object OnBackArrowClick : SettingsEvent()
    data object OnRateUsClick : SettingsEvent()
    data object OnPrivacyPolicyClick : SettingsEvent()
    data object OnTermsClick : SettingsEvent()
    data object OnContactUsClick : SettingsEvent()
    data object OnLanguageClick : SettingsEvent()
}

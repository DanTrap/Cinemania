package com.dantrap.cinemania.fintech.feature.settings.language.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class LanguageEvent {
    data object OnBackArrowClick : LanguageEvent()
    class ChangeLanguage(val newLanguage: String) : LanguageEvent()
    class FetchAvailableLocales(val mapAvailableLocales: Map<String, String>) : LanguageEvent()
    data object FetchCurrentLanguage : LanguageEvent()
}

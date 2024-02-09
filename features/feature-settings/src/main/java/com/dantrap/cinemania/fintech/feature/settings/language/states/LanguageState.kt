package com.dantrap.cinemania.fintech.feature.settings.language.states

import androidx.compose.runtime.Immutable

@Immutable
data class LanguageState(
    val currentLanguage: String = "en",
    val mapLocales: Map<String, String> = mapOf()
)

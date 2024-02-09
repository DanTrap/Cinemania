package com.dantrap.cinemania.fintech.feature.settings.language.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class LanguageSideEffect {
    data object NavigateBack : LanguageSideEffect()
}

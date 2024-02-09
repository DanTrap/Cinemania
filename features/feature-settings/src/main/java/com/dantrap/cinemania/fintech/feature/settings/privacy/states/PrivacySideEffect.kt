package com.dantrap.cinemania.fintech.feature.settings.privacy.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class PrivacySideEffect {
    data object NavigateBack : PrivacySideEffect()
}

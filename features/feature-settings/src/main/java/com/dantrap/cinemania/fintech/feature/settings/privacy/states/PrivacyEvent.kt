package com.dantrap.cinemania.fintech.feature.settings.privacy.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class PrivacyEvent {
    data object LoadPrivacy : PrivacyEvent()
    data object OnBackArrowClick : PrivacyEvent()
}

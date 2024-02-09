package com.dantrap.cinemania.fintech.feature.settings.terms.states

import androidx.compose.runtime.Immutable

@Immutable
sealed class TermsEvent {
    data object LoadPrivacy : TermsEvent()
    data object OnBackArrowClick : TermsEvent()
}

package com.dantrap.cinemania.fintech.feature.settings.privacy

import com.dantrap.cinemania.fintech.core.common.utils.SettingsConstants
import com.dantrap.cinemania.fintech.core.mvi.BaseViewModel
import com.dantrap.cinemania.fintech.feature.settings.privacy.states.PrivacyEvent
import com.dantrap.cinemania.fintech.feature.settings.privacy.states.PrivacySideEffect
import com.dantrap.cinemania.fintech.feature.settings.privacy.states.PrivacyState
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class PrivacyViewModel : BaseViewModel<PrivacyState, PrivacySideEffect, PrivacyEvent>(
    initialState = PrivacyState()
) {

    init {
        onEvent(PrivacyEvent.LoadPrivacy)
    }

    override fun onEvent(event: PrivacyEvent) {
        when (event) {
            PrivacyEvent.LoadPrivacy -> loadPrivacy()
            PrivacyEvent.OnBackArrowClick -> navigateBack()
        }
    }

    private fun loadPrivacy() {
        intent { reduce { state.copy(url = SettingsConstants.privacy) } }
    }

    private fun navigateBack() {
        intent { postSideEffect(PrivacySideEffect.NavigateBack) }
    }
}

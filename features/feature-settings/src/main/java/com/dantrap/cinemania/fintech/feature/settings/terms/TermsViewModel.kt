package com.dantrap.cinemania.fintech.feature.settings.terms

import com.dantrap.cinemania.fintech.core.common.utils.SettingsConstants
import com.dantrap.cinemania.fintech.core.mvi.BaseViewModel
import com.dantrap.cinemania.fintech.feature.settings.terms.states.TermsEvent
import com.dantrap.cinemania.fintech.feature.settings.terms.states.TermsSideEffect
import com.dantrap.cinemania.fintech.feature.settings.terms.states.TermsState
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class TermsViewModel : BaseViewModel<TermsState, TermsSideEffect, TermsEvent>(
    initialState = TermsState()
) {

    init {
        onEvent(TermsEvent.LoadPrivacy)
    }

    override fun onEvent(event: TermsEvent) {
        when (event) {
            TermsEvent.LoadPrivacy -> loadPrivacy()
            TermsEvent.OnBackArrowClick -> navigateBack()
        }
    }

    private fun loadPrivacy() {
        intent { reduce { state.copy(url = SettingsConstants.terms) } }
    }

    private fun navigateBack() {
        intent { postSideEffect(TermsSideEffect.NavigateBack) }
    }
}

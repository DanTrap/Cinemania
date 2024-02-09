package com.dantrap.cinemania.fintech.feature.settings.menu

import com.dantrap.cinemania.fintech.core.domain.usecase.ContactUsUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.RateUsUseCase
import com.dantrap.cinemania.fintech.core.mvi.BaseViewModel
import com.dantrap.cinemania.fintech.feature.settings.menu.states.SettingsEvent
import com.dantrap.cinemania.fintech.feature.settings.menu.states.SettingsSideEffect
import com.dantrap.cinemania.fintech.feature.settings.menu.states.SettingsState
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

class SettingsViewModel(
    private val contactUsUseCase: ContactUsUseCase,
    private val rateUsUseCase: RateUsUseCase,
) : BaseViewModel<SettingsState, SettingsSideEffect, SettingsEvent>(
    initialState = SettingsState()
) {

    override fun onEvent(event: SettingsEvent) {
        when (event) {
            SettingsEvent.OnBackArrowClick -> navigateBack()
            SettingsEvent.OnContactUsClick -> contactUs()
            SettingsEvent.OnLanguageClick -> navigateToLanguages()
            SettingsEvent.OnPrivacyPolicyClick -> navigateToPrivacyPolicy()
            SettingsEvent.OnTermsClick -> navigateToTerms()
            SettingsEvent.OnRateUsClick -> rateUs()
        }
    }

    private fun navigateBack() {
        intent { postSideEffect(SettingsSideEffect.NavigateBack) }
    }

    private fun navigateToLanguages() {
        intent { postSideEffect(SettingsSideEffect.NavigateToLanguages) }
    }

    private fun navigateToPrivacyPolicy() {
        intent { postSideEffect(SettingsSideEffect.NavigateToPrivacyPolicy) }
    }

    private fun navigateToTerms() {
        intent { postSideEffect(SettingsSideEffect.NavigateToTerms) }
    }

    private fun contactUs() = contactUsUseCase()

    private fun rateUs() = rateUsUseCase()
}

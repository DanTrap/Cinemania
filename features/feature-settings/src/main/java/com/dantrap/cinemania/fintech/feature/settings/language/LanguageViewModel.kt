package com.dantrap.cinemania.fintech.feature.settings.language

import com.dantrap.cinemania.fintech.core.domain.repository.LanguageRepository
import com.dantrap.cinemania.fintech.core.mvi.BaseViewModel
import com.dantrap.cinemania.fintech.feature.settings.language.states.LanguageEvent
import com.dantrap.cinemania.fintech.feature.settings.language.states.LanguageSideEffect
import com.dantrap.cinemania.fintech.feature.settings.language.states.LanguageState
import kotlinx.coroutines.flow.first
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class LanguageViewModel(
    private val languageRepository: LanguageRepository,
) : BaseViewModel<LanguageState, LanguageSideEffect, LanguageEvent>(
    initialState = LanguageState()
) {

    init {
        onEvent(LanguageEvent.FetchCurrentLanguage)
    }

    override fun onEvent(event: LanguageEvent) {
        when (event) {
            LanguageEvent.OnBackArrowClick -> navigateBack()
            is LanguageEvent.ChangeLanguage -> changeLanguage(event.newLanguage)
            is LanguageEvent.FetchAvailableLocales -> fetchAvailableLocales(event.mapAvailableLocales)
            is LanguageEvent.FetchCurrentLanguage -> fetchCurrentLocale()
        }
    }

    private fun navigateBack() {
        intent {
            postSideEffect(LanguageSideEffect.NavigateBack)
        }
    }

    private fun changeLanguage(newLanguage: String) {
        intent {
            languageRepository.changeLanguage(newLanguage)
            reduce { state.copy(currentLanguage = newLanguage) }
        }
    }

    private fun fetchAvailableLocales(availableMapLocales: Map<String, String>) {
        intent { reduce { state.copy(mapLocales = availableMapLocales) } }
    }

    private fun fetchCurrentLocale() {
        intent {
            val language = languageRepository.language().first()
            reduce { state.copy(currentLanguage = language) }
        }
    }
}

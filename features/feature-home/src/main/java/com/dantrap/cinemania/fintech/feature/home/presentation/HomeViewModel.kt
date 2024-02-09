package com.dantrap.cinemania.fintech.feature.home.presentation

import androidx.lifecycle.viewModelScope
import com.dantrap.cinemania.fintech.core.domain.repository.LanguageRepository
import com.dantrap.cinemania.fintech.core.mvi.BaseViewModel
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeEvent
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeSideEffect
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class HomeViewModel(
    private val languageRepository: LanguageRepository,
) : BaseViewModel<HomeState, HomeSideEffect, HomeEvent>(
    initialState = HomeState()
) {

    init {
        onEvent(HomeEvent.ObserveLanguage)
    }

    override fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.ObserveLanguage -> observeCurrentLanguage()
            HomeEvent.OnSettingsClick -> navigateToSettings()
        }
    }

    private fun observeCurrentLanguage() {
        intent {
            languageRepository.language().onEach {
                reduce { state.copy(isLoading = false) }
            }.launchIn(viewModelScope)
        }
    }

    private fun navigateToSettings() {
        intent { postSideEffect(HomeSideEffect.NavigateToSettings) }
    }
}

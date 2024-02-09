package com.dantrap.cinemania.fintech.feature.settings.di

import com.dantrap.cinemania.fintech.feature.settings.language.LanguageViewModel
import com.dantrap.cinemania.fintech.feature.settings.menu.SettingsViewModel
import com.dantrap.cinemania.fintech.feature.settings.privacy.PrivacyViewModel
import com.dantrap.cinemania.fintech.feature.settings.terms.TermsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object SettingsModule {

    val module = module {

        viewModelOf(::SettingsViewModel)

        viewModelOf(::LanguageViewModel)

        viewModelOf(::PrivacyViewModel)

        viewModelOf(::TermsViewModel)
    }
}

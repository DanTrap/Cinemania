package com.dantrap.cinemania.fintech.feature.home.di

import com.dantrap.cinemania.fintech.feature.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object HomeModule {

    val module = module {

        viewModelOf(::HomeViewModel)
    }
}

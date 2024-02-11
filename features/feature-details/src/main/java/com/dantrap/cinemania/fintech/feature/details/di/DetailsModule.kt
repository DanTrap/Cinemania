package com.dantrap.cinemania.fintech.feature.details.di

import com.dantrap.cinemania.fintech.feature.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object DetailsModule {

    val module = module {

        viewModelOf(::DetailsViewModel)
    }
}

package com.dantrap.cinemania.fintech.feature.search.di

import com.dantrap.cinemania.fintech.feature.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object SearchModule {

    val module = module {

        viewModelOf(::SearchViewModel)
    }
}

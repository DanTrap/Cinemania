package com.dantrap.cinemania.fintech.feature.favorite.di

import com.dantrap.cinemania.fintech.feature.favorite.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object FavoriteModule {

    val module = module {

        viewModelOf(::FavoriteViewModel)
    }
}

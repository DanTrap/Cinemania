package com.dantrap.cinemania.fintech.di

import com.dantrap.cinemania.fintech.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module

object AppModule {

    val module = module {

        single(named("API_KEY")) { BuildConfig.API_KEY }
    }
}

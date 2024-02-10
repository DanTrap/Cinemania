package com.dantrap.cinemania.fintech.core.domain.di

import com.dantrap.cinemania.fintech.core.domain.usecase.ContactUsUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.GetMoviesUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.RateUsUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object DomainModule {

    val module = module {

        singleOf(::ContactUsUseCase)

        singleOf(::RateUsUseCase)

        singleOf(::GetMoviesUseCase)
    }
}

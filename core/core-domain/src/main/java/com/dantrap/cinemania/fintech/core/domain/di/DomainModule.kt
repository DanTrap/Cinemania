package com.dantrap.cinemania.fintech.core.domain.di

import com.dantrap.cinemania.fintech.core.domain.usecase.AddMovieToFavoriteUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.ContactUsUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.GetFavoriteMovieUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.GetMovieDetailsUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.GetMoviesUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.RateUsUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.RemoveMovieFromFavoriteUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.SearchMoviesByKeywordUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object DomainModule {

    val module = module {

        singleOf(::ContactUsUseCase)

        singleOf(::RateUsUseCase)

        singleOf(::GetMoviesUseCase)

        singleOf(::GetMovieDetailsUseCase)

        singleOf(::RemoveMovieFromFavoriteUseCase)

        singleOf(::AddMovieToFavoriteUseCase)

        singleOf(::GetFavoriteMovieUseCase)

        singleOf(::SearchMoviesByKeywordUseCase)
    }
}

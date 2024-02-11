package com.dantrap.cinemania.fintech.core.data.di

import com.dantrap.cinemania.fintech.core.data.repository.AppReviewManagerImpl
import com.dantrap.cinemania.fintech.core.data.repository.ContactUsManagerImpl
import com.dantrap.cinemania.fintech.core.data.repository.FavoriteMovieRepositoryImpl
import com.dantrap.cinemania.fintech.core.data.repository.LanguageRepositoryImpl
import com.dantrap.cinemania.fintech.core.data.repository.MovieDetailsRepositoryImpl
import com.dantrap.cinemania.fintech.core.data.repository.RemoteMovieRepositoryImpl
import com.dantrap.cinemania.fintech.core.domain.repository.AppReviewManager
import com.dantrap.cinemania.fintech.core.domain.repository.ContactUsManager
import com.dantrap.cinemania.fintech.core.domain.repository.FavoriteMovieRepository
import com.dantrap.cinemania.fintech.core.domain.repository.LanguageRepository
import com.dantrap.cinemania.fintech.core.domain.repository.MovieDetailsRepository
import com.dantrap.cinemania.fintech.core.domain.repository.MovieRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object DataModule {

    val module = module {

        singleOf(::LanguageRepositoryImpl) bind LanguageRepository::class

        singleOf(::ContactUsManagerImpl) bind ContactUsManager::class

        singleOf(::AppReviewManagerImpl) bind AppReviewManager::class

        singleOf(::RemoteMovieRepositoryImpl) bind MovieRepository::class

        singleOf(::MovieDetailsRepositoryImpl) bind MovieDetailsRepository::class

        singleOf(::FavoriteMovieRepositoryImpl) bind FavoriteMovieRepository::class
    }
}

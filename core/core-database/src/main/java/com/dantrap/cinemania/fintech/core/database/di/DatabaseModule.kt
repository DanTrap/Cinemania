package com.dantrap.cinemania.fintech.core.database.di

import android.content.Context
import androidx.room.Room
import com.dantrap.cinemania.fintech.core.database.CinemaniaDatabase
import com.dantrap.cinemania.fintech.core.database.dao.MovieDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object DatabaseModule {

    val module = module {

        single { provideDatabase(context = androidApplication()) }

        single { provideMovieDao(database = get()) }
    }

    private fun provideDatabase(
        context: Context,
    ): CinemaniaDatabase = Room.databaseBuilder(
        context = context,
        klass = CinemaniaDatabase::class.java,
        name = CinemaniaDatabase.CINEMANIA_DATABASE
    ).build()

    private fun provideMovieDao(database: CinemaniaDatabase): MovieDao = database.movieDao
}

package com.dantrap.cinemania.fintech.core.common.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.bind
import org.koin.dsl.module

object DispatchersModule {

    val module = module {

        single { Dispatchers.IO } bind CoroutineDispatcher::class

        factory { provideCoroutineScope(dispatcher = get()) }
    }

    private fun provideCoroutineScope(dispatcher: CoroutineDispatcher): CoroutineScope =
        CoroutineScope(dispatcher)
}

package com.dantrap.cinemania.fintech.core.common.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DispatchersModule {

    val module = module {

        single(named("DispatcherIO")) { Dispatchers.IO }

        factory { provideCoroutineScope(dispatcher = get(named("DispatcherIO"))) }
    }

    private fun provideCoroutineScope(dispatcher: CoroutineDispatcher): CoroutineScope =
        CoroutineScope(dispatcher)
}

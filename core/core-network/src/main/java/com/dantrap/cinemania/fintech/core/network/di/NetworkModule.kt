package com.dantrap.cinemania.fintech.core.network.di

import com.dantrap.cinemania.fintech.core.network.api.AuthInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

object NetworkModule {

    val module = module {

        single(named("AuthInterceptor")) {
            provideAuthInterceptor(key = get(named("API_KEY")))
        }

        single { provideOkHttpClient(authInterceptor = get(named("AuthInterceptor"))) }
    }

    private fun provideOkHttpClient(authInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

    private fun provideAuthInterceptor(key: String): Interceptor = AuthInterceptor(key)
}

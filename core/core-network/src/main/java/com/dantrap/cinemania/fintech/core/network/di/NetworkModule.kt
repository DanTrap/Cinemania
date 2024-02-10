package com.dantrap.cinemania.fintech.core.network.di

import com.dantrap.cinemania.fintech.core.network.api.AuthInterceptor
import com.dantrap.cinemania.fintech.core.network.api.service.MovieService
import com.dantrap.cinemania.fintech.core.network.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    val module = module {

        single(named("AuthInterceptor")) {
            provideAuthInterceptor(key = get(named("API_KEY")))
        }

        single { provideOkHttpClient(authInterceptor = get(named("AuthInterceptor"))) }

        single { provideMovieService(okHttpClient = get()) }
    }

    private fun provideOkHttpClient(authInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

    private fun provideAuthInterceptor(key: String): Interceptor = AuthInterceptor(key)

    private fun provideMovieService(okHttpClient: OkHttpClient): MovieService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.API_URL)
        .client(okHttpClient)
        .build()
        .create(MovieService::class.java)

}

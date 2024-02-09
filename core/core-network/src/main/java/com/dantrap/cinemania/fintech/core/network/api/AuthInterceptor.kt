package com.dantrap.cinemania.fintech.core.network.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val key: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.request()
        .newBuilder()
        .addHeader("API-KEY", key)
        .build()
        .run {
            chain.proceed(this)
        }
}

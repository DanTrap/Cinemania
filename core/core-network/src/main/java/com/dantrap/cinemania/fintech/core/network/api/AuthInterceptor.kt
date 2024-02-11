package com.dantrap.cinemania.fintech.core.network.api

import com.dantrap.cinemania.fintech.core.network.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val key: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.request()
        .newBuilder()
        .addHeader(Constants.API_KEY_HEADER_PARAM, key)
        .build()
        .run {
            chain.proceed(this)
        }
}

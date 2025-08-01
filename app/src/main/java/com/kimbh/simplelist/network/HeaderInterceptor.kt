package com.kimbh.simplelist.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val newRequest = originalRequest.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "KakaoAK 88f6bbfb8581190546b54dba45c4c6d6")
            .build()

        return chain.proceed(newRequest)
    }
}
package com.kimbh.simplelist.di

import com.kimbh.simplelist.data.remote.api.ApiService
import com.kimbh.simplelist.network.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideHeaderInterceptor(): Interceptor = HeaderInterceptor()

    @Provides
    fun provideOkHttpClient(headerInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .build()

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com/v2/search/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideSectionApi(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
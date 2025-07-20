package com.kimbh.simplelist.di

import com.kimbh.simplelist.data.repository.ImagesRepositoryImpl
import com.kimbh.simplelist.domain.repository.ImagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindImageRepository(
        impl: ImagesRepositoryImpl
    ): ImagesRepository
}
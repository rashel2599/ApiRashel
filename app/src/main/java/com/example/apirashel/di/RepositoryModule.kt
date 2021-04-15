package com.example.apirashel.di

import com.example.apirashel.repository.DogRepository
import com.example.apirashel.retrofit.DogNetworkEntity
import com.example.apirashel.retrofit.DogRetrofit
import com.example.apirashel.retrofit.NetworkMapper
import com.example.apirashel.room.CacheMapper
import com.example.apirashel.room.DogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDogRepository(
        dogDao: DogDao,
        dogRetrofit: DogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): DogRepository {
        return DogRepository(dogDao, dogRetrofit, cacheMapper, networkMapper)
    }
}
package com.example.apirashel.di

import android.app.Application
import com.example.apirashel.utils.AdapterDogs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)

object AdapterModule {

    @Singleton
    @Provides
    fun providesAdapterGenres(application: Application): AdapterDogs {
        return AdapterDogs()
    }
}

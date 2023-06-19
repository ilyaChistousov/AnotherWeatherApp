package chistousov.ilya.anotherweatherapp.adapter.splash.di

import chistousov.ilya.anotherweatherapp.adapter.splash.repository.SplashScreenRepositoryAdapter
import chistousov.ilya.splash.domain.repository.SplashRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface SplashScreenRepositoryModule {

    @Binds
    fun bindsSplashScreenRepository(impl: SplashScreenRepositoryAdapter): SplashRepository
}
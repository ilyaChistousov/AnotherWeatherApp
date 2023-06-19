package chistousov.ilya.anotherweatherapp.adapter.splash.di

import chistousov.ilya.anotherweatherapp.adapter.splash.SplashScreenRouterImpl
import chistousov.ilya.splash.presentation.SplashScreenRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface SplashScreenRouterModule {

    @Binds
    fun bindsSplashScreenRouter(impl: SplashScreenRouterImpl): SplashScreenRouter
}
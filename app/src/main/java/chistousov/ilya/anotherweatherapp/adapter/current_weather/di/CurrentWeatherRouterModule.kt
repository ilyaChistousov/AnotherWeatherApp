package chistousov.ilya.anotherweatherapp.adapter.current_weather.di

import chistousov.ilya.anotherweatherapp.adapter.current_weather.CurrentWeatherRouterImpl
import chistousov.ilya.current_weather.presentation.CurrentWeatherRouter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface CurrentWeatherRouterModule {

    @Binds
    fun bindCurrentWeatherRouter(impl: CurrentWeatherRouterImpl): CurrentWeatherRouter
}
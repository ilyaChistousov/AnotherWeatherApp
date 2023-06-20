package chistousov.ilya.anotherweatherapp.adapter.weather_details.di

import chistousov.ilya.anotherweatherapp.adapter.weather_details.repository.WeatherDetailsRepositoryAdapter
import chistousov.ilya.weather_details.domain.repository.WeatherDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface WeatherDetailsModule {

    @Binds
    fun bindWeatherDetailsRepository(
        weatherDetailsRepositoryAdapter: WeatherDetailsRepositoryAdapter
    ): WeatherDetailsRepository
}
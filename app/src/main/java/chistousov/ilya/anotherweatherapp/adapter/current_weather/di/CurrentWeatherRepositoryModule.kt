package chistousov.ilya.anotherweatherapp.adapter.current_weather.di

import chistousov.ilya.anotherweatherapp.adapter.current_weather.reposiroty.CurrentWeatherRepositoryAdapter
import chistousov.ilya.current_weather.domain.repository.CurrentWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface CurrentWeatherRepositoryModule {

    @Binds
    fun bindCurrentWeatherRepository(impl: CurrentWeatherRepositoryAdapter): CurrentWeatherRepository
}
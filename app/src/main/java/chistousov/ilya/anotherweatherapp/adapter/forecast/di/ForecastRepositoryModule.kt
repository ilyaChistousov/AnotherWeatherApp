package chistousov.ilya.anotherweatherapp.adapter.forecast.di

import chistousov.ilya.anotherweatherapp.adapter.forecast.repository.ForecastRepositoryAdapter
import chistousov.ilya.forecast.domain.repository.ForecastRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface ForecastRepositoryModule {

    @Binds
    fun bindForecastRepository(adapter: ForecastRepositoryAdapter): ForecastRepository
}
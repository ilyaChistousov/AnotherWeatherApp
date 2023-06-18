package chistousov.ilya.anotherweatherapp.adapter.navigation.di

import chistousov.ilya.anotherweatherapp.adapter.navigation.DestinationProviderImpl
import chistousov.ilya.navigation.presentation.navigation.DestinationProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavigationProvider {

    @Binds
    fun bindDestinationProvider(provider: DestinationProviderImpl): DestinationProvider
}
package chistousov.ilya.anotherweatherapp.adapter.navigation

import chistousov.ilya.anotherweatherapp.R
import chistousov.ilya.navigation.presentation.navigation.DestinationProvider
import javax.inject.Inject

class DestinationProviderImpl @Inject constructor() : DestinationProvider {

    override fun provideNavigationGraphId() = R.navigation.nav_graph

    override fun provideStartDestinationId() = R.id.splashScreenFragment
}
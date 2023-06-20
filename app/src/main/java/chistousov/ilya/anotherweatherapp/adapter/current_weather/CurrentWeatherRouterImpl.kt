package chistousov.ilya.anotherweatherapp.adapter.current_weather

import chistousov.ilya.anotherweatherapp.R
import chistousov.ilya.current_weather.presentation.CurrentWeatherRouter
import chistousov.ilya.navigation.presentation.navigation.AppComponentRouter
import javax.inject.Inject

class CurrentWeatherRouterImpl @Inject constructor(
    private val appComponentRouter: AppComponentRouter
) : CurrentWeatherRouter {
    override fun launchWeatherDetails() {
        appComponentRouter.launch(R.id.weatherDetailsFragment)
    }

    override fun launchForecast() {
        appComponentRouter.launch(R.id.forecastFragment)
    }
}
package chistousov.ilya.anotherweatherapp.adapter.splash

import chistousov.ilya.anotherweatherapp.R
import chistousov.ilya.current_weather.presentation.CurrentWeatherFragment
import chistousov.ilya.navigation.presentation.navigation.AppComponentRouter
import chistousov.ilya.splash.presentation.SplashScreenRouter
import javax.inject.Inject

class SplashScreenRouterImpl @Inject constructor(
    private val appComponentRouter: AppComponentRouter
) : SplashScreenRouter {
    override fun launchCurrentWeather() {
        appComponentRouter.launch(R.id.currentWeatherFragment)
    }
}
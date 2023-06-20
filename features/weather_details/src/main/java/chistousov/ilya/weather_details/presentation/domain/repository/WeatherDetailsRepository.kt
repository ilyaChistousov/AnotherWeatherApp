package chistousov.ilya.weather_details.presentation.domain.repository

import chistousov.ilya.weather_details.presentation.domain.entity.WeatherDetails

interface WeatherDetailsRepository {

    suspend fun getWeatherDetails(): WeatherDetails
}
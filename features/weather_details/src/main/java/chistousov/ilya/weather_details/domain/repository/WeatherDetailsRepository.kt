package chistousov.ilya.weather_details.domain.repository

import chistousov.ilya.weather_details.domain.entity.WeatherDetails

interface WeatherDetailsRepository {

    suspend fun getWeatherDetails(): WeatherDetails
}
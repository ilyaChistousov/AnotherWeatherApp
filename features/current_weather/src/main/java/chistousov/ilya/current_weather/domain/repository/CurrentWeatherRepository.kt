package chistousov.ilya.current_weather.domain.repository

import chistousov.ilya.current_weather.domain.entity.CurrentWeather
import kotlinx.coroutines.flow.Flow

interface CurrentWeatherRepository {

//    suspend fun getCurrentWeather(city: String, lang: String, units: String): CurrentWeather

    suspend fun getDefaultWeather(): CurrentWeather
}
package chistousov.ilya.data.current_weather

import chistousov.ilya.data.api.WeatherService
import chistousov.ilya.data.api.dto.CurrentWeatherDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataCurrentWeatherRepository @Inject constructor(
    private val weatherService: WeatherService
) {

    suspend fun getCurrentWeather(city: String, lang: String, units: String): Flow<CurrentWeatherDto> = flow {
        emit(weatherService.getCurrentWeatherByCity(city))
    }.flowOn(Dispatchers.IO)
}
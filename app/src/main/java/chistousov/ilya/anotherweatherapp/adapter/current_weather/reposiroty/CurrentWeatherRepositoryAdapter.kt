package chistousov.ilya.anotherweatherapp.adapter.current_weather.reposiroty

import chistousov.ilya.anotherweatherapp.mapper.CurrentWeatherMapper
import chistousov.ilya.current_weather.domain.entity.CurrentWeather
import chistousov.ilya.current_weather.domain.repository.CurrentWeatherRepository
import chistousov.ilya.data.current_weather.DataCurrentWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CurrentWeatherRepositoryAdapter @Inject constructor(
    private val dataCurrentWeatherRepository: DataCurrentWeatherRepository,
    private val mapper: CurrentWeatherMapper
) : CurrentWeatherRepository {

//    override suspend fun getCurrentWeather(
//        city: String,
//        lang: String,
//        units: String
//    ): Flow<CurrentWeather> {
//        return dataCurrentWeatherRepository.getCurrentWeather().map {
//            mapper.map(it)
//        }
//    }

    override suspend fun getDefaultWeather(): Flow<CurrentWeather> {
        return dataCurrentWeatherRepository.getCurrentWeather().map { mapper.map(it) }
    }
}
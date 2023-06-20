package chistousov.ilya.anotherweatherapp.adapter.weather_details.repository

import chistousov.ilya.anotherweatherapp.adapter.weather_details.mapper.WeatherDetailsMapper
import chistousov.ilya.data.weather_details.DataWeatherDetailsRepository
import chistousov.ilya.weather_details.presentation.domain.entity.WeatherDetails
import chistousov.ilya.weather_details.presentation.domain.repository.WeatherDetailsRepository
import javax.inject.Inject

class WeatherDetailsRepositoryAdapter @Inject constructor(
    private val dataWeatherDetailsRepository: DataWeatherDetailsRepository,
    private val mapper: WeatherDetailsMapper
) : WeatherDetailsRepository {

    override suspend fun getWeatherDetails(): WeatherDetails {
        return mapper.map(dataWeatherDetailsRepository.getLatestData())
    }
}
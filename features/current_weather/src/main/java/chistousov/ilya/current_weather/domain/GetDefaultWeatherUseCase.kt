package chistousov.ilya.current_weather.domain

import chistousov.ilya.current_weather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class GetDefaultWeatherUseCase @Inject constructor(
    private val repository: CurrentWeatherRepository
) {

    suspend operator fun invoke() = repository.getDefaultWeather()
}
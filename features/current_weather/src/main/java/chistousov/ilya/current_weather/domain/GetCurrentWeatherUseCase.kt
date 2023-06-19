package chistousov.ilya.current_weather.domain

import chistousov.ilya.current_weather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: CurrentWeatherRepository) {

    suspend operator fun invoke(city: String, lang: String, units: String) =
        repository.getCurrentWeather(city, lang, units)
}
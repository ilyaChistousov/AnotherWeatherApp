package chistousov.ilya.current_weather.domain

import chistousov.ilya.common.Result
import chistousov.ilya.current_weather.domain.entity.CurrentWeather
import chistousov.ilya.current_weather.domain.repository.CurrentWeatherRepository
import javax.inject.Inject

class GetDefaultWeatherUseCase @Inject constructor(
    private val repository: CurrentWeatherRepository
) {

    suspend operator fun invoke(): Result<CurrentWeather> {
        return try {
            Result.Success(repository.getDefaultWeather())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
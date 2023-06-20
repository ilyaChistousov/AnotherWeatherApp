package chistousov.ilya.weather_details.domain

import chistousov.ilya.common.Result
import chistousov.ilya.weather_details.domain.entity.WeatherDetails
import chistousov.ilya.weather_details.domain.repository.WeatherDetailsRepository
import javax.inject.Inject

class GetWeatherDetailsUseCase @Inject constructor(private val repository: WeatherDetailsRepository) {

    suspend operator fun invoke(): Result<WeatherDetails> {
       return try {
           Result.Success(repository.getWeatherDetails())
       } catch (e: Exception) {
           Result.Error(e)
       }
    }
}
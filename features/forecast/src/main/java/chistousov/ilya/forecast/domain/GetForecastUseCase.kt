package chistousov.ilya.forecast.domain

import chistousov.ilya.common.Result
import chistousov.ilya.forecast.domain.entity.Forecast
import chistousov.ilya.forecast.domain.entity.ForecastItem
import chistousov.ilya.forecast.domain.repository.ForecastRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(private val repository: ForecastRepository) {

    suspend operator fun invoke(): Result<Forecast> {
        return try {
            Result.Success(repository.getForecast())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}
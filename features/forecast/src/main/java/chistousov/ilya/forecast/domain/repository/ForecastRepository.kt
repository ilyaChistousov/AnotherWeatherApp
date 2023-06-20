package chistousov.ilya.forecast.domain.repository

import chistousov.ilya.forecast.domain.entity.Forecast

interface ForecastRepository {

    suspend fun getForecast(): Forecast
}

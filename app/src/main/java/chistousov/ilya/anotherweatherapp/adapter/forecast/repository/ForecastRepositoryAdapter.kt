package chistousov.ilya.anotherweatherapp.adapter.forecast.repository

import chistousov.ilya.anotherweatherapp.adapter.current_weather.forecast.DataForecastRepository
import chistousov.ilya.anotherweatherapp.adapter.forecast.mapper.ForecastMapper
import chistousov.ilya.forecast.domain.entity.Forecast
import chistousov.ilya.forecast.domain.entity.ForecastItem
import chistousov.ilya.forecast.domain.repository.ForecastRepository
import javax.inject.Inject

class ForecastRepositoryAdapter @Inject constructor(
    private val dataForecastRepository: DataForecastRepository,
    private val forecastMapper: ForecastMapper
) : ForecastRepository {

    override suspend fun getForecast(): Forecast {
        return forecastMapper.map(dataForecastRepository.getForecast())
    }
}
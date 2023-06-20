package chistousov.ilya.anotherweatherapp.adapter.current_weather.forecast

import chistousov.ilya.data.room.dao.ForecastDao
import chistousov.ilya.data.room.entity.ForecastEntity
import javax.inject.Inject

class DataForecastRepository @Inject constructor(
    private val forecastDao: ForecastDao
) {

    suspend fun getForecast(): ForecastEntity {
        return forecastDao.getForecast()
    }
}
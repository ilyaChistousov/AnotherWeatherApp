package chistousov.ilya.data.splash_screen

import android.util.Log
import chistousov.ilya.data.api.WeatherService
import chistousov.ilya.data.mapper.CurrentWeatherDtoMapper
import chistousov.ilya.data.mapper.TimeIntervalListMapper
import chistousov.ilya.data.mapper.formatTimeToString
import chistousov.ilya.data.room.dao.ForecastDao
import chistousov.ilya.data.room.dao.LatestDataDao
import chistousov.ilya.data.room.entity.ForecastEntity
import chistousov.ilya.data.room.entity.TimeInterval
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataSplashScreenRepository @Inject constructor(
    private val latestDataDao: LatestDataDao,
    private val forecastDao: ForecastDao,
    private val weatherService: WeatherService,
    private val currentWeatherDtoMapper: CurrentWeatherDtoMapper,
    private val timeIntervalListMapper: TimeIntervalListMapper
    ) {

    suspend fun loadDefaultLocation() = withContext(Dispatchers.IO) {
        try{
            val currentWeatherDto = weatherService.getCurrentWeatherByCity("Санкт-Петербург", "en")
            val forecastDto = weatherService.getForecastForecastsByCity("Санкт-Петербург", "en")
            val latestDataEntity = currentWeatherDtoMapper.map(currentWeatherDto)
            val forecastEntity = ForecastEntity(
                city = latestDataEntity.city,
                temp = latestDataEntity.temp,
                tempMax = latestDataEntity.tempMax,
                tempMin = latestDataEntity.tempMin,
                currentTime = currentWeatherDto.dt.formatTimeToString("hh:mm"),
                forecast = timeIntervalListMapper.map(forecastDto.list))
            latestDataDao.insertLatestData(latestDataEntity)
            forecastDao.insertForecast(forecastEntity)
            return@withContext true
        } catch (e: Exception) {
            throw e
        }
    }
}
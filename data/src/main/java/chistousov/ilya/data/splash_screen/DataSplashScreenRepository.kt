package chistousov.ilya.data.splash_screen

import chistousov.ilya.common.MissingInternetException
import chistousov.ilya.data.api.WeatherService
import chistousov.ilya.data.mapper.CurrentWeatherDtoMapper
import chistousov.ilya.data.mapper.TimeIntervalListMapper
import chistousov.ilya.data.mapper.formatTimeToString
import chistousov.ilya.data.room.dao.ForecastDao
import chistousov.ilya.data.room.dao.LatestDataDao
import chistousov.ilya.data.room.entity.ForecastEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
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
                currentTime = currentWeatherDto.dt.formatTimeToString(),
                forecast = timeIntervalListMapper.map(forecastDto.list))
            latestDataDao.insertLatestData(latestDataEntity)
            forecastDao.insertForecast(forecastEntity)
            return@withContext true
        } catch (e: HttpException) {
            throw MissingInternetException()
        } catch (e: IOException) {
            throw MissingInternetException()
        }
    }
}
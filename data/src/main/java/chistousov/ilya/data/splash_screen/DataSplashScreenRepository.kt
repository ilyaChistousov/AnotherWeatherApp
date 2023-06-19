package chistousov.ilya.data.splash_screen

import android.util.Log
import chistousov.ilya.data.api.WeatherService
import chistousov.ilya.data.mapper.DtoMapper
import chistousov.ilya.data.room.dao.LatestDataDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataSplashScreenRepository @Inject constructor(
    private val latestDataDao: LatestDataDao,
    private val weatherService: WeatherService,
    private val mapper: DtoMapper
) {

    suspend fun loadDefaultLocation() = withContext(Dispatchers.IO) {
        try{
            val currentWeatherDto = weatherService.getCurrentWeatherByCity("Санкт-Петербург", "ru")
            val latestDataEntity = mapper.map(currentWeatherDto)
            latestDataDao.insertLatestData(latestDataEntity)
            return@withContext true
        } catch (e: Exception) {
            throw e
        }
    }
}
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
            val currentWeatherDto = weatherService.getCurrentWeatherByCity("Moscow", "ru")
            return@withContext true
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun loadCurrentWeather(latitude: Double, longitude: Double) = withContext(Dispatchers.IO) {
        try {
            val currentWeatherDto = weatherService.getCurrentWeatherByCoordinates(latitude, longitude)
            latestDataDao.insertLatestData(mapper.map(currentWeatherDto))
        } catch (e: Exception) {
            throw e
        }

        return@withContext true
    }
}
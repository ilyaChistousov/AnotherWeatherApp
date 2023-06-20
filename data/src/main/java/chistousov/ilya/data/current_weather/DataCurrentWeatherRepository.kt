package chistousov.ilya.data.current_weather

import chistousov.ilya.data.room.dao.LatestDataDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataCurrentWeatherRepository @Inject constructor(
    private val latestDataDao: LatestDataDao
) {
    suspend fun getCurrentWeather() = withContext(Dispatchers.IO) {
        return@withContext latestDataDao.getLatestData()
    }
}
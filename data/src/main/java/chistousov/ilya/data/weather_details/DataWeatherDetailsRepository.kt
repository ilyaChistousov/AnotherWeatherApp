package chistousov.ilya.data.weather_details

import chistousov.ilya.data.room.dao.LatestDataDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataWeatherDetailsRepository @Inject constructor(
    private val latestDataDao: LatestDataDao
) {

    suspend fun getLatestData() = withContext(Dispatchers.IO) {
        latestDataDao.getLatestData()
    }
}
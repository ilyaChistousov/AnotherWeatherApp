package chistousov.ilya.data.current_weather

import chistousov.ilya.data.api.WeatherService
import chistousov.ilya.data.api.dto.CurrentWeatherDto
import chistousov.ilya.data.mapper.DtoMapper
import chistousov.ilya.data.room.dao.LatestDataDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataCurrentWeatherRepository @Inject constructor(
    private val latestDataDao: LatestDataDao,
    private val weatherService: WeatherService,
    private val mapper: DtoMapper
) {
    suspend fun getCurrentWeather() = withContext(Dispatchers.IO) {
        return@withContext latestDataDao.getLatestData()
    }
}
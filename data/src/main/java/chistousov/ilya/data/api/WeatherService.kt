package chistousov.ilya.data.api

import chistousov.ilya.data.api.dto.CurrentWeatherDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.POST
import retrofit2.http.Query

interface WeatherService {

    @POST("weather")
    suspend fun getCurrentWeatherByCity(
        @Query("q") cityName: String,
        @Query("lang") lang: String = "ru",
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = "d9e6fe2ca9bd114df14262b014663852"
    ) : CurrentWeatherDto
}
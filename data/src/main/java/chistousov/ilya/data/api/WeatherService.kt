package chistousov.ilya.data.api

import chistousov.ilya.data.api.dto.CurrentWeatherDto
import chistousov.ilya.data.api.dto.ForecastDto
import retrofit2.http.POST
import retrofit2.http.Query

interface WeatherService {

    @POST("weather")
    suspend fun getCurrentWeatherByCity(
        @Query("q") cityName: String,
        @Query("lang") lang: String = "ru",
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = "d9e6fe2ca9bd114df14262b014663852"
    ): CurrentWeatherDto

    @POST("weather")
    suspend fun getCurrentWeatherByCoordinates(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("lang") lang: String = "ru",
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = "d9e6fe2ca9bd114df14262b014663852"
    ): CurrentWeatherDto

    @POST("forecast")
    suspend fun getForecastForecastsByCity(
        @Query("q") cityName: String,
        @Query("lang") lang: String = "ru",
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = "d9e6fe2ca9bd114df14262b014663852"
    ): ForecastDto
}
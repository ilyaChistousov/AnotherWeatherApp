package chistousov.ilya.forecast.domain.entity

data class Forecast(
    val city: String,
    val temp: Int,
    val tempMax: Int,
    val tempMin: Int,
    val currentTime: String,
    val forecast: List<ForecastItem>
)

data class ForecastItem(
    val time: String,
    val temp: Int
)

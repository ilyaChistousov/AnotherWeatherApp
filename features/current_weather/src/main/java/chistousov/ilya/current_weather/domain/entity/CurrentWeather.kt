package chistousov.ilya.current_weather.domain.entity

data class CurrentWeather(
    val city: String,
    val temp: Int,
    val feelsLike: Int,
    val tempMin: Int,
    val tempMax: Int,
    val description: String
)
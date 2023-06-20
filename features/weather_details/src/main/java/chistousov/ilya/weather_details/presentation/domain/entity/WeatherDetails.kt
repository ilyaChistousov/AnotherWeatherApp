package chistousov.ilya.weather_details.presentation.domain.entity

data class WeatherDetails(
    val city: String,
    val temp: Int,
    val feelsLike: Int,
    val tempMin: Int,
    val tempMax: Int,
    val description: String,
    val wind: Double,
    val pressure: Int,
    val humidity: Int,
    val clouds: Int,
)
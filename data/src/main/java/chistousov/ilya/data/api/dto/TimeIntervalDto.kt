package chistousov.ilya.data.api.dto

import com.google.gson.annotations.SerializedName

data class TimeIntervalDto(
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("dt") val dt: Int,
    @SerializedName("dt_txt") val dt_txt: String,
    @SerializedName("main") val main: MainForecast,
    @SerializedName("pop") val pop: Double,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("wind") val wind: WindForecast
)
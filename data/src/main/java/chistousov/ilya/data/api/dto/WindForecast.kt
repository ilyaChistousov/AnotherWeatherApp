package chistousov.ilya.data.api.dto

import com.google.gson.annotations.SerializedName

data class WindForecast(
    @SerializedName("deg") val deg: Int,
    @SerializedName("gust") val gust: Double,
    @SerializedName("speed")val speed: Double
)
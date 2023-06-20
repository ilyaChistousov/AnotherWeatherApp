package chistousov.ilya.data.api.dto

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("city") val city: City,
    @SerializedName("cnt") val cnt: Int,
    @SerializedName("cod") val cod: String,
    @SerializedName("list") val list: List<TimeIntervalDto>,
    @SerializedName("message") val message: Int
)
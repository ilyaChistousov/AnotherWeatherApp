package chistousov.ilya.data.api.dto

import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all") val all: Int
)
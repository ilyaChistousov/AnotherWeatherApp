package chistousov.ilya.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "latest_data")
data class LatestDataEntity(
    @PrimaryKey val id: Int = 1,
    val city: String,
    val temp: Int,
    val feelsLike: Int,
    val time: Int,
    val tempMax: Int,
    val tempMin: Int,
    val pressure: Int,
    val humidity: Int,
    val wind: Double,
    val weatherDescription: String,
    val clouds: Int
)
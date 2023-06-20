package chistousov.ilya.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "forecast")
data class ForecastEntity(
    @PrimaryKey
    val id: Int = 1,
    val city: String,
    val temp: Int,
    val tempMax: Int,
    val tempMin: Int,
    val currentTime: String,
    val forecast: List<TimeInterval>
)

data class TimeInterval(
    val time: String,
    val temp: Int
)


class TimeIntervalListConverter {

    @TypeConverter
    fun fromList(list: List<TimeInterval>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(data: String): List<TimeInterval> {
        val type = object : TypeToken<List<TimeInterval>>() {}.type
        return Gson().fromJson(data, type)
    }
}
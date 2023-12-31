package chistousov.ilya.data.mapper

import chistousov.ilya.common.BaseMapper
import chistousov.ilya.data.api.dto.CurrentWeatherDto
import chistousov.ilya.data.room.entity.LatestDataEntity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import kotlin.math.roundToInt

class CurrentWeatherDtoMapper @Inject constructor(): BaseMapper<CurrentWeatherDto, LatestDataEntity> {

    override fun map(input: CurrentWeatherDto): LatestDataEntity {
        return LatestDataEntity(
            city = input.name,
            temp = input.main.temp.roundToInt(),
            feelsLike = input.main.feels_like.roundToInt(),
            tempMax = input.main.temp_max.roundToInt(),
            tempMin = input.main.temp_min.roundToInt(),
            pressure = input.main.pressure,
            wind = input.wind.speed,
            weatherDescription = input.weather[0].main,
            time = input.dt.formatTimeToString(),
            clouds = input.clouds.all,
            humidity = input.main.humidity,
        )
    }
}
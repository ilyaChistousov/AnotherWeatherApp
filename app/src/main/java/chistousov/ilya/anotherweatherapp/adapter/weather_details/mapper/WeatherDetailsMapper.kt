package chistousov.ilya.anotherweatherapp.adapter.weather_details.mapper

import chistousov.ilya.common.BaseMapper
import chistousov.ilya.data.room.entity.LatestDataEntity
import chistousov.ilya.weather_details.domain.entity.WeatherDetails
import javax.inject.Inject

class WeatherDetailsMapper @Inject constructor(): BaseMapper<LatestDataEntity, WeatherDetails> {

    override fun map(input: LatestDataEntity) = WeatherDetails(
        input.city,
        input.time,
        input.temp,
        input.feelsLike,
        input.tempMin,
        input.tempMax,
        input.weatherDescription,
        input.wind,
        input.pressure,
        input.humidity,
        input.clouds
    )
}
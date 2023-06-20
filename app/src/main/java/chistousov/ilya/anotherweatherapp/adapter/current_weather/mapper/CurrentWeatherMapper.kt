package chistousov.ilya.anotherweatherapp.adapter.current_weather.mapper

import chistousov.ilya.common.BaseMapper
import chistousov.ilya.current_weather.domain.entity.CurrentWeather
import chistousov.ilya.data.room.entity.LatestDataEntity
import javax.inject.Inject

class CurrentWeatherMapper @Inject constructor(): BaseMapper<LatestDataEntity, CurrentWeather> {

    override fun map(input: LatestDataEntity): CurrentWeather {
        return CurrentWeather(
            city = input.city,
            temp = input.temp,
            feelsLike = input.feelsLike,
            tempMin = input.tempMin,
            tempMax = input.tempMax,
            description = input.weatherDescription
        )
    }
}
package chistousov.ilya.anotherweatherapp.mapper

import chistousov.ilya.common.BaseMapper
import chistousov.ilya.current_weather.domain.entity.CurrentWeather
import chistousov.ilya.data.api.dto.CurrentWeatherDto
import javax.inject.Inject

class CurrentWeatherMapper @Inject constructor(): BaseMapper<CurrentWeatherDto, CurrentWeather> {

    override fun map(input: CurrentWeatherDto): CurrentWeather {
        return CurrentWeather(
            city = input.name,
            temp = input.main.temp.toInt(),
            feelsLike = input.main.feels_like.toInt()
        )
    }
}
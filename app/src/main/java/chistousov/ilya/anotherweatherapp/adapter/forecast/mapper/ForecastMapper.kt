package chistousov.ilya.anotherweatherapp.adapter.forecast.mapper

import chistousov.ilya.common.BaseMapper
import chistousov.ilya.data.room.entity.ForecastEntity
import chistousov.ilya.forecast.domain.entity.Forecast
import chistousov.ilya.forecast.domain.entity.ForecastItem
import javax.inject.Inject

class ForecastMapper @Inject constructor() : BaseMapper<ForecastEntity, Forecast> {

    override fun map(input: ForecastEntity) = Forecast(
        city = input.city,
        temp = input.temp,
        tempMax = input.tempMax,
        tempMin = input.tempMin,
        currentTime = input.currentTime,
        forecast = input.forecast.map {
            ForecastItem(
                time = it.time,
                temp = it.temp
            )
        }
    )
}
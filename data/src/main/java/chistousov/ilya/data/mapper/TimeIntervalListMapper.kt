package chistousov.ilya.data.mapper

import chistousov.ilya.common.BaseMapper
import chistousov.ilya.data.api.dto.TimeIntervalDto
import chistousov.ilya.data.room.entity.TimeInterval
import javax.inject.Inject
import kotlin.math.roundToInt

class TimeIntervalListMapper @Inject constructor() : BaseMapper<List<TimeIntervalDto>, List<TimeInterval>> {

    override fun map(input: List<TimeIntervalDto>): List<TimeInterval> {
        return input.map {
            TimeInterval(
                time = it.dt.formatTimeToString("dd.MM, hh:mm"),
                temp = it.main.temp.roundToInt()
            )
        }
    }
}
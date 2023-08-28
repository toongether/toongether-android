package kr.toongether.data.model

import kr.toongether.model.DayOfWeek
import kr.toongether.network.model.NetworkDayOfWeek

fun NetworkDayOfWeek.asModel(): DayOfWeek = when (this) {
    NetworkDayOfWeek.MONDAY -> DayOfWeek.MONDAY
    NetworkDayOfWeek.TUESDAY -> DayOfWeek.TUESDAY
    NetworkDayOfWeek.WEDNESDAY -> DayOfWeek.WEDNESDAY
    NetworkDayOfWeek.THURSDAY -> DayOfWeek.THURSDAY
    NetworkDayOfWeek.FRIDAY -> DayOfWeek.FRIDAY
    NetworkDayOfWeek.SATURDAY -> DayOfWeek.SATURDAY
    NetworkDayOfWeek.SUNDAY -> DayOfWeek.SUNDAY
    else -> DayOfWeek.ALL
}
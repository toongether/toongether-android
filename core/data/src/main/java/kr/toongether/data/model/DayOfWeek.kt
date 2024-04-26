package kr.toongether.data.model

import kr.toongether.model.DayOfWeek

internal fun String.asDayOfWeek() = when (this) {
    DayOfWeek.MONDAY.name -> DayOfWeek.MONDAY
    DayOfWeek.TUESDAY.name -> DayOfWeek.TUESDAY
    DayOfWeek.WEDNESDAY.name -> DayOfWeek.WEDNESDAY
    DayOfWeek.THURSDAY.name -> DayOfWeek.THURSDAY
    DayOfWeek.FRIDAY.name -> DayOfWeek.FRIDAY
    DayOfWeek.SATURDAY.name -> DayOfWeek.SATURDAY
    DayOfWeek.SUNDAY.name -> DayOfWeek.SUNDAY
    else -> DayOfWeek.MONDAY
}

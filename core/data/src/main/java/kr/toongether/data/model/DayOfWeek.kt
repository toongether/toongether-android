package kr.toongether.data.model

fun NetworkDayOfWeek.asModel(): DayOfWeek = when (this) {
    NetworkDayOfWeek.MONDAY -> DayOfWeek.MONDAY
    NetworkDayOfWeek.TUESDAY -> DayOfWeek.TUESDAY
    NetworkDayOfWeek.WEDNESDAY -> DayOfWeek.WEDNESDAY
    NetworkDayOfWeek.THURSDAY -> DayOfWeek.THURSDAY
    NetworkDayOfWeek.FRIDAY -> DayOfWeek.FRIDAY
    NetworkDayOfWeek.SATURDAY -> DayOfWeek.SATURDAY
    NetworkDayOfWeek.SUNDAY -> DayOfWeek.SUNDAY
}

fun DayOfWeek.asRequest(): NetworkDayOfWeek = when (this) {
    DayOfWeek.MONDAY -> NetworkDayOfWeek.MONDAY
    DayOfWeek.TUESDAY -> NetworkDayOfWeek.TUESDAY
    DayOfWeek.WEDNESDAY -> NetworkDayOfWeek.WEDNESDAY
    DayOfWeek.THURSDAY -> NetworkDayOfWeek.THURSDAY
    DayOfWeek.FRIDAY -> NetworkDayOfWeek.FRIDAY
    DayOfWeek.SATURDAY -> NetworkDayOfWeek.SATURDAY
    DayOfWeek.SUNDAY -> NetworkDayOfWeek.SUNDAY
}

package kr.toongether.common

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn

fun LocalDateTime.toRelativeDateTime(): String {
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    return if (this.year < today.year) "${today.year - this.year}년 전"
    else if (this.monthNumber < today.monthNumber) "${today.monthNumber - this.monthNumber}달 전"
    else if (this.dayOfMonth < today.dayOfMonth) "${today.dayOfMonth - this.dayOfMonth}일 전"
    else "오래전"
}

fun LocalDateTime.toSimpleDate(): String =
    "${year}년 ${monthNumber}월 ${dayOfMonth}일"

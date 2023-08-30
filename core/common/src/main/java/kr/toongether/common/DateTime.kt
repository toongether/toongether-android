package kr.toongether.common

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.math.abs

fun LocalDateTime.toRelativeDateTime(): String {
    val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    return if (this.year < today.year) {
        "${today.year - this.year}년 전"
    } else if (this.monthNumber < today.monthNumber) {
        "${today.monthNumber - this.monthNumber}달 전"
    } else if (this.dayOfMonth < today.dayOfMonth) {
        "${today.dayOfMonth - this.dayOfMonth}일 전"
    } else if (this.hour < today.hour) {
        if (today.hour - this.hour < 1 && this.minute > today.minute) {
            "${60 - abs(this.minute - today.minute)}분 전"
        } else {
            "${today.hour - this.hour}시간 전"
        }
    } else {
        "방금 전"
    }
}

fun LocalDateTime.toSimpleDate(): String =
    "${year}년 ${monthNumber}월 ${dayOfMonth}일"

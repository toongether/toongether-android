package kr.toongether.data.model

import kr.toongether.model.SerialCycle

internal fun String.asSerialCycle() = when (this) {
    SerialCycle.WEEKLY.name -> SerialCycle.WEEKLY
    SerialCycle.BIWEEKLY.name -> SerialCycle.BIWEEKLY
    SerialCycle.MONTH.name -> SerialCycle.MONTH
    else -> SerialCycle.WEEKLY
}

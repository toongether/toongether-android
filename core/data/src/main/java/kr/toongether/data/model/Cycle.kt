package kr.toongether.data.model

import kr.toongether.model.Cycle
import kr.toongether.network.model.NetworkCycle

fun NetworkCycle.asModel(): Cycle = when (this) {
    NetworkCycle.WEEKLY -> Cycle.WEEKLY
    NetworkCycle.BIWEEKLY -> Cycle.BIWEEKLY
    NetworkCycle.MONTH -> Cycle.MONTH
}

fun Cycle.asRequest(): NetworkCycle = when (this) {
    Cycle.WEEKLY -> NetworkCycle.WEEKLY
    Cycle.BIWEEKLY -> NetworkCycle.BIWEEKLY
    Cycle.MONTH -> NetworkCycle.MONTH
}

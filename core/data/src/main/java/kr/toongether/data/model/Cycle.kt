package kr.toongether.data.model

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

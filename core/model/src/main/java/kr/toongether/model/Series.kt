package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class Series(
    val id: Long,
    val title: String,
    val titleInfo: TitleInfo,
    val dayOfWeek: DayOfWeek,
    val cycle: Cycle,
    val genre: String,
    val author: Author,
    val createdDate: LocalDateTime
)

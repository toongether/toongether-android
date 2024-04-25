package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class Series(
    val id: Long,
    val title: String,
    val description: String,
    val titleMaker: TitleMaker,
    val publishStatus: PublishStatus,
    val dayOfWeek: DayOfWeek,
    val serialCycle: SerialCycle,
    val genre: List<String>,
    val author: Author,
    val createdDate: LocalDateTime,
)

package kr.toongether.model

import java.time.LocalDateTime

data class SeriesList(
    val id: Long,
    val title: String,
    val titleInfo: TitleInfo,
    val dayOfWeek: DayOfWeek,
    val cycle: Cycle,
    val genre: String,
    val author: Author,
    val createdDate: LocalDateTime,
    val hasMorePage: Boolean,
    val currentPage: Int,
)

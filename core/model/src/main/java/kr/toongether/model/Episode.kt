package kr.toongether.model

import java.time.LocalDateTime

data class Episode(
    val id: Long,
    val title: String,
    val thumbnail: String,
    val createdDate: LocalDateTime,
)

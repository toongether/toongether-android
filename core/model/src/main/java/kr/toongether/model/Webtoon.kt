package kr.toongether.model

import java.time.LocalDateTime

data class Webtoon(
    val createDate: LocalDateTime,
    val id: Long,
    val title: String,
    val writer: String,
    val thumbnail: String,
)

package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class Comic(
    val title: String,
    val thumbnail: String,
    val imageUrl: List<String>,
    val createdDate: LocalDateTime,
    val width: Int,
    val height: Int,
    val lastHeight: Int,
    val endIndex: Int
)

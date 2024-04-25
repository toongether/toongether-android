package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class Shorts(
    val id: Long,
    val title: String,
    val genre: List<String>,
    val thumbnail: String,
    val likeCount: Int,
    val commentCount: Int,
    val author: Author,
    val views: Int,
    val createdDate: LocalDateTime,
    val liked: Boolean,
)

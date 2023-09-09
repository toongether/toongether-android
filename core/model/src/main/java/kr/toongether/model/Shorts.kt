package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class Shorts(
    val id: Long,
    val title: String,
    val genre: String,
    val thumbnail: String,
    val commentCount: Int,
    val likeCount: Int,
    val author: Author,
    val createdDate: LocalDateTime,
    val isLiked: Boolean
)

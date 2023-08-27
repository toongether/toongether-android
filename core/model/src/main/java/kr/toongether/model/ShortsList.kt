package kr.toongether.model

import java.time.LocalDateTime

data class ShortsList(
    val id: Long,
    val title: String,
    val genre: String,
    val thumbnail: String,
    val commentCount: Int,
    val likeCount: Int,
    val author: Author,
    val createdDate: LocalDateTime,
    val hasMorePage: Boolean,
    val currentPage: Int,
)

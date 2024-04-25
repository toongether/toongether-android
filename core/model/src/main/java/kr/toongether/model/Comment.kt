package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class Comment(
    val id: Long,
    val body: String,
    val author: String,
    val userId: Long,
    val createdDate: LocalDateTime,
)

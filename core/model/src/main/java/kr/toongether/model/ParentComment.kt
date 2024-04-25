package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class ParentComment(
    val body: String,
    val author: String,
    val userId: Long,
    val createdDate: LocalDateTime,
)

package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class Episode(
    val episodeNumber: Int,
    val episodeId: Long,
    val title: String,
    val thumbnail: String,
    val likeCount: Int,
    val commentCount: Int,
    val createdDate: LocalDateTime,
    val liked: Boolean
)

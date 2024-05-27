package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class ShortsDetail(
    val id: Long,
    val title: String,
    val thumbnail: String,
    val imageURL: List<String>,
    val genre: List<String>,
    val createdDate: LocalDateTime,
    val width: Int,
    val height: Int,
    val lastHeight: Int,
    val endIndex: Int,
    val beforeEpisode: Long?,
    val nextEpisode: Long?,
    val likeCount: Int,
    val commentCount: Int,
    val views: Int,
    val liked: Boolean,
)

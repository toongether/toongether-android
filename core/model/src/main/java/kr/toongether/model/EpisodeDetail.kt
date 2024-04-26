package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class EpisodeDetail(
    val id: Long,
    val seriesTitle: String,
    val episodeTitle: String,
    val titleMakerColor: String,
    val thumbnail: String,
    val imageURL: List<String>,
    val createdDate: LocalDateTime,
    val width: Int,
    val height: Int,
    val lastHeight: Int,
    val endIndex: Int,
    val beforeEpisode: Long,
    val nextEpisode: Long,
    val likeCount: Int,
    val commentCount: Int,
    val views: Int,
    val liked: Boolean,
)

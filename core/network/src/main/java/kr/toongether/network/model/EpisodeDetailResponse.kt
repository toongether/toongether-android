package kr.toongether.network.model

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeDetailResponse(
    @SerialName("id") val id: Long,
    @SerialName("seriesTitle") val seriesTitle: String,
    @SerialName("episodeTitle") val episodeTitle: String,
    @SerialName("titlemakerColor") val titleMakerColor: String,
    @SerialName("thumbnail") val thumbnail: String,
    @SerialName("imageURL") val imageURL: List<String>,
    @SerialName("createdDate") val createdDate: Instant,
    @SerialName("width") val width: Int,
    @SerialName("height") val height: Int,
    @SerialName("lastHeight") val lastHeight: Int,
    @SerialName("endIndex") val endIndex: Int,
    @SerialName("beforeEpisode") val beforeEpisode: Long,
    @SerialName("nextEpisode") val nextEpisode: Long,
    @SerialName("likeCount") val likeCount: Int,
    @SerialName("commentCount") val commentCount: Int,
    @SerialName("views") val views: Int,
    @SerialName("liked") val liked: Boolean,
)

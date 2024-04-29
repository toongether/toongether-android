package kr.toongether.network.model

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortsResponse(
    @SerialName("id") val id: Long,
    @SerialName("title") val title: String,
    @SerialName("genre") val genre: List<String>,
    @SerialName("thumbnail") val thumbnail: String,
    @SerialName("likeCount") val likeCount: Int,
    @SerialName("commentCount") val commentCount: Int,
    @SerialName("author") val author: NetworkAuthor,
    @SerialName("views") val views: Int,
    @SerialName("createdDate") val createdDate: Instant,
    @SerialName("liked") val liked: Boolean,
)

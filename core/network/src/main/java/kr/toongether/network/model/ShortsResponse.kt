package kr.toongether.network.model

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortsResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("genre")
    val genre: String,
    @SerialName("thumbnail")
    val thumbnail: String,
    @SerialName("commentCount")
    val commentCount: Int,
    @SerialName("author")
    val author: NetworkAuthor,
    @SerialName("createdDate")
    val createdDate: Instant
)

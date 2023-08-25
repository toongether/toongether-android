package kr.toongether.network.model

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
    @SerialName("likeCount")
    val likeCount: Int,
    @SerialName("author")
    val author: AuthorResponse,
    @SerialName("createdDate")
    val createdDate: String,
    @SerialName("hasMorePage")
    val hasMorePage: Int,
    @SerialName("currentPage")
    val currentPage: Int,
)

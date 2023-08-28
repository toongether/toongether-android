package kr.toongether.network.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortsListResponse(
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
    val author: NetworkAuthor,
    @SerialName("createdDate")
    val createdDate: LocalDateTime,
    @SerialName("hasMorePage")
    val hasMorePage: Boolean,
    @SerialName("currentPage")
    val currentPage: Int,
)
package kr.toongether.network.model

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComicResponse(
    @SerialName("title")
    val title: String,
    @SerialName("thumbnail")
    val thumbnail: String,
    @SerialName("imageURL")
    val imageUrl: List<String>,
    @SerialName("createdDate")
    val createdDate: Instant,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("lastHeight")
    val lastHeight: Int,
    @SerialName("endIndex")
    val endIndex: Int
)

package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComicListResponse(
    @SerialName("imageURL")
    val imageUrl: List<String>,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("lastHeight")
    val lastHeight: Int,
    @SerialName("endIndex")
    val endIndex: Int
)

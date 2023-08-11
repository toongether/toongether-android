package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortsResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("writer")
    val writer: String,
    @SerialName("thumbnail")
    val thumbnail: String,
    @SerialName("createdDate")
    val createdDate: String
)

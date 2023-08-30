package kr.toongether.network.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkEpisode(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("thumbnail")
    val thumbnail: String,
    @SerialName("createdDate")
    val createdDate: LocalDateTime
)

package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComicViewResponse<T>(
    @SerialName("type")
    val type: NetworkViewType,
    @SerialName("children")
    val children: T
)

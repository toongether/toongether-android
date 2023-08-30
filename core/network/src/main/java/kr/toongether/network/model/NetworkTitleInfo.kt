package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkTitleInfo(
    @SerialName("color")
    val color: String,
    @SerialName("titleWidth")
    val titleWidth: Float,
    @SerialName("titleImage")
    val titleImage: String,
    @SerialName("backgroundImage")
    val thumbnailImage: String
)

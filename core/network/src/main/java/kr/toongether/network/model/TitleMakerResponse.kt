package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TitleMakerResponse(
    @SerialName("font") val font: String,
    @SerialName("color") val color: String,
    @SerialName("titleSvg") val titleSvg: String,
    @SerialName("backgroundImage") val backgroundImage: String,
)

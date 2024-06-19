package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TitleMakerEpisodeResponse(
    @SerialName("font") val font: String,
    @SerialName("color") val color: String,
    @SerialName("alignCenterTitleSvg") val alignCenterTitleSvg: String,
    @SerialName("alignLeftTitleSvg") val alignLeftTitleSvg: String,
    @SerialName("backgroundImage") val backgroundImage: String,
)

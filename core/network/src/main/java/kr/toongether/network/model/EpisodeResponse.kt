package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    @SerialName("titleMaker")
    val titleInfo: NetworkTitleInfo,
    @SerialName("author")
    val author: NetworkAuthor,
    @SerialName("episodeList")
    val episodeList: List<NetworkEpisode>,
)

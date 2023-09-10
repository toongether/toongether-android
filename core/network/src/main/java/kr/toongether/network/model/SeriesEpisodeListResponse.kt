package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesEpisodeListResponse(
    @SerialName("cycle")
    val cycle: NetworkCycle,
    @SerialName("dayOfWeek")
    val dayOfWeek: NetworkDayOfWeek,
    @SerialName("genre")
    val genre: String,
    @SerialName("titleMaker")
    val titleMaker: TitleMakerResponse,
    @SerialName("author")
    val author: NetworkAuthor,
    @SerialName("episodeList")
    val episodeList: List<EpisodeResponse>
)

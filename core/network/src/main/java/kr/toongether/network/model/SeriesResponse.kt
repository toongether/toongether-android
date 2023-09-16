package kr.toongether.network.model

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("titleMaker")
    val titleInfo: TitleMakerResponse,
    @SerialName("dayOfWeek")
    val dayOfWeek: NetworkDayOfWeek,
    @SerialName("cycle")
    val cycle: NetworkCycle,
    @SerialName("genre")
    val genre: String,
    @SerialName("author")
    val author: NetworkAuthor,
    @SerialName("createdDate")
    val createdDate: Instant
)

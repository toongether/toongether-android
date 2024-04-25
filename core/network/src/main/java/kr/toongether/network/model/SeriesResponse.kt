package kr.toongether.network.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesResponse(
    @SerialName("id") val id: Long,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("titleMaker") val titleMaker: TitleMakerResponse,
    @SerialName("publishStatus") val publishStatus: String,
    @SerialName("dayOfWeek") val dayOfWeek: String,
    @SerialName("cycle") val serialCycle: String,
    @SerialName("genre") val genre: List<String>,
    @SerialName("author") val author: NetworkAuthor,
    @SerialName("createdDate") val createdDate: LocalDateTime,
)

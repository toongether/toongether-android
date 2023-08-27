package kr.toongether.network.model

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesListResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("titleMaker")
    val titleInfo: NetworkTitleInfo,
    @SerialName("dayOfWeek")
    val dayOfWeek: NetworkDayOfWeek,
    @SerialName("cycle")
    val cycle: NetworkCycle,
    @SerialName("genre")
    val genre: String,
    @SerialName("author")
    val author: NetworkAuthor,
    @SerialName("createdDate")
    val createdDate: LocalDateTime,
    @SerialName("hasMorePage")
    val hasMorePage: Boolean,
    @SerialName("currentPage")
    val currentPage: Int,
)

package kr.toongether.network.model

import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComicViewResponse(
    @SerialName("type")
    val viewType: NetworkViewType? = null,
    @SerialName("children")
    val children: List<ComicViewResponse>? = null,
    @SerialName("id")
    val id: Long? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("genre")
    val genre: String? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("likeCount")
    val likeCount: Int? = null,
    @SerialName("commentCount")
    val commentCount: Int? = null,
    @SerialName("liked")
    val liked: Boolean? = null,
    @SerialName("titleMaker")
    val titleInfo: TitleMakerResponse? = null,
    @SerialName("dayOfWeek")
    val dayOfWeek: NetworkDayOfWeek? = null,
    @SerialName("cycle")
    val cycle: NetworkCycle? = null,
    @SerialName("author")
    val author: NetworkAuthor? = null,
    @SerialName("createdDate")
    val createdDate: Instant? = null
)

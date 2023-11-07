package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class ComicView(
    val viewType: ViewType?,
    val children: List<ComicView>?,
    val id: Long?,
    val title: String?,
    val genre: String?,
    val thumbnail: String?,
    val likeCount: Int?,
    val commentCount: Int?,
    val liked: Boolean?,
    val titleInfo: TitleInfo?,
    val dayOfWeek: DayOfWeek?,
    val cycle: Cycle?,
    val author: Author?,
    val createdDate: LocalDateTime?
)

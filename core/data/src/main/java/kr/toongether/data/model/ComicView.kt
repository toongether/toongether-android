package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kr.toongether.model.ComicView
import kr.toongether.model.ViewType
import kr.toongether.network.model.ComicViewResponse
import kr.toongether.network.model.NetworkViewType


fun ComicViewResponse.asModel(): ComicView = ComicView(
    viewType = viewType?.asModel(),
    children = children?.map { it.asModel() },
    id = id,
    title = title,
    genre = genre,
    thumbnail = thumbnail,
    likeCount = likeCount,
    commentCount = commentCount,
    liked = liked,
    titleInfo = titleInfo?.asModel(),
    dayOfWeek = dayOfWeek?.asModel(),
    cycle = cycle?.asModel(),
    author = author?.asModel(),
    createdDate = createdDate?.toLocalDateTime(TimeZone.currentSystemDefault()),
)
fun NetworkViewType.asModel(): ViewType = when (this) {
    NetworkViewType.SERIES_BANNER -> ViewType.SERIES_BANNER
    NetworkViewType.SHORTS_CONTAINER -> ViewType.SHORTS_CONTAINER
    NetworkViewType.SERIES_CONTAINER -> ViewType.SERIES_CONTAINER
}

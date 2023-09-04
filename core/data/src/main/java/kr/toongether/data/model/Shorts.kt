package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kr.toongether.model.Shorts
import kr.toongether.model.ShortsList
import kr.toongether.network.model.ShortsListResponse
import kr.toongether.network.model.ShortsResponse

fun ShortsListResponse.asModel(): ShortsList = ShortsList(
    shortsList = shortsResponse.map { it.asModel() },
    hasMorePage = hasMorePage,
    currentPage = currentPage
)

fun ShortsResponse.asModel(): Shorts = Shorts(
    id = id,
    title = title,
    genre = genre,
    thumbnail = thumbnail,
    commentCount = commentCount,
    likeCount = 0,
    author = author.asModel(),
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault())
)

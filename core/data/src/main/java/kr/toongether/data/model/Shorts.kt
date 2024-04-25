package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

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
    likeCount = likeCount,
    author = author.asModel(),
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault()),
    liked = liked
)

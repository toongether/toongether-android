package kr.toongether.data.model

import kotlinx.datetime.LocalDateTime
import kr.toongether.model.Author
import kr.toongether.model.ShortsList
import kr.toongether.network.model.ShortsListResponse

fun ShortsListResponse.asModel(): ShortsList = ShortsList(
    id = id,
    title = title,
    genre = genre,
    thumbnail = thumbnail,
    commentCount = commentCount,
    likeCount = likeCount,
    author = author.asModel(),
    createdDate = createdDate,
    hasMorePage = hasMorePage,
    currentPage = currentPage
)

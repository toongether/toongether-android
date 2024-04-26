package kr.toongether.data.model

import kr.toongether.model.Shorts
import kr.toongether.network.model.ShortsResponse

internal fun ShortsResponse.asModel() = Shorts(
    id = id,
    title = title,
    genre = genre,
    thumbnail = thumbnail,
    likeCount = likeCount,
    commentCount = commentCount,
    author = author.asModel(),
    views = views,
    createdDate = createdDate,
    liked = liked
)

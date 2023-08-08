package kr.toongether.data.model

import kr.toongether.model.Shorts
import kr.toongether.network.model.ShortsResponse

fun ShortsResponse.asModel(): Shorts = Shorts(
    createdDate = createdDate,
    id = id,
    title = title,
    writer = writer,
    thumbnail = thumbnail
)

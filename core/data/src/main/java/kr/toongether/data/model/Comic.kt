package kr.toongether.data.model

import kr.toongether.model.Comic
import kr.toongether.network.model.ComicResponse

fun ComicResponse.asModel(): Comic = Comic(
    title = title,
    thumbnail = thumbnail,
    imageUrl = imageUrl,
    createdDate = createdDate,
    width = width,
    height = height,
    lastHeight = lastHeight,
    endIndex = endIndex,
)

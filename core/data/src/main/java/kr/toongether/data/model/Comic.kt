package kr.toongether.data.model

import kr.toongether.model.ComicList
import kr.toongether.network.model.ComicResponse

fun ComicResponse.asModel(): ComicList = ComicList(
    imageUrl = imageUrl,
    width = width,
    height = height,
    lastHeight = lastHeight,
    endIndex = endIndex
)

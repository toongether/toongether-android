package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun ComicResponse.asModel(): Comic = Comic(
    id = id,
    title = title,
    thumbnail = thumbnail,
    imageUrl = imageUrl,
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault()),
    width = width,
    height = height,
    lastHeight = lastHeight,
    endIndex = endIndex,
    beforeEpisode = beforeEpisode,
    nextEpisode = nextEpisode,
    likeCount = likeCount,
    commentCount = commentCount,
    liked = liked
)

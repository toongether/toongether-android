package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun EpisodeResponse.asModel(): Episode = Episode(
    episodeNumber = episodeNumber,
    episodeId = episodeId,
    title = title,
    thumbnail = thumbnail,
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault()),
    commentCount = commentCount,
    likeCount = likeCount,
    liked = liked
)

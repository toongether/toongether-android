package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kr.toongether.model.Episode
import kr.toongether.network.model.EpisodeResponse

internal fun EpisodeResponse.asModel() = Episode(
    episodeNumber = episodeNumber,
    episodeId = episodeId,
    title = title,
    thumbnail = thumbnail,
    likeCount = likeCount,
    commentCount = commentCount,
    views = views,
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault()),
    liked = liked,
)
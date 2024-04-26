package kr.toongether.data.model

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
    createdDate = createdDate,
    liked = liked,
)
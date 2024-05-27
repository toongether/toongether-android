package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kr.toongether.model.EpisodeDetail
import kr.toongether.model.ShortsDetail
import kr.toongether.network.model.EpisodeDetailResponse
import kr.toongether.network.model.ShortsDetailResponse

internal fun ShortsDetailResponse.asModel() = ShortsDetail(
    id = id,
    title = title,
    thumbnail = thumbnail,
    imageURL = imageURL,
    genre = genre,
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault()),
    width = width,
    height = height,
    lastHeight = lastHeight,
    endIndex = endIndex,
    beforeEpisode = beforeEpisode,
    nextEpisode = nextEpisode,
    likeCount = likeCount,
    commentCount = commentCount,
    views = views,
    liked = liked,
)

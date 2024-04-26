package kr.toongether.data.model

import kr.toongether.model.EpisodeDetail
import kr.toongether.network.model.EpisodeDetailResponse

internal fun EpisodeDetailResponse.asModel() = EpisodeDetail(
    id = id,
    seriesTitle = seriesTitle,
    episodeTitle = episodeTitle,
    titleMakerColor = titleMakerColor,
    thumbnail = thumbnail,
    imageURL = imageURL,
    createdDate = createdDate,
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

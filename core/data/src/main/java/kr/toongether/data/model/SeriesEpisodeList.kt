package kr.toongether.data.model

import kr.toongether.model.SeriesEpisodeList
import kr.toongether.network.model.SeriesEpisodeListResponse

internal fun SeriesEpisodeListResponse.asModel() = SeriesEpisodeList(
    title = title,
    description = description,
    titleMaker = titleMaker.asModel(),
    publishStatus = publishStatus.asPublishStatus(),
    dayOfWeek = dayOfWeek.asDayOfWeek(),
    serialCycle = serialCycle.asSerialCycle(),
    genre = genre,
    author = author.asModel(),
    episodeList = episodeList.map { it.asModel() }
)

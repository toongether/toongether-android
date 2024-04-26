package kr.toongether.data.model

import kr.toongether.model.Series
import kr.toongether.network.model.SeriesResponse

internal fun SeriesResponse.asModel() = Series(
    id = id,
    title = title,
    description = description,
    titleMaker = titleMaker.asModel(),
    publishStatus = publishStatus.asPublishStatus(),
    dayOfWeek = dayOfWeek.asDayOfWeek(),
    serialCycle = serialCycle.asSerialCycle(),
    genre = genre,
    author = author.asModel(),
    createdDate = createdDate
)
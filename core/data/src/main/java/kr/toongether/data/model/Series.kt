package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
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
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault())
)
package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kr.toongether.model.Episode
import kr.toongether.network.model.NetworkEpisode

fun NetworkEpisode.asModel(): Episode = Episode(
    id = id,
    title = title,
    thumbnail = thumbnail,
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault())
)

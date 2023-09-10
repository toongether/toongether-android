package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kr.toongether.model.Series
import kr.toongether.model.SeriesEpisodeList
import kr.toongether.model.SeriesList
import kr.toongether.network.model.SeriesEpisodeListResponse
import kr.toongether.network.model.SeriesListResponse
import kr.toongether.network.model.SeriesResponse

fun SeriesEpisodeListResponse.asModel(): SeriesEpisodeList = SeriesEpisodeList(
    cycle = cycle.asModel(),
    dayOfWeek = dayOfWeek.asModel(),
    titleInfo = titleMaker.asModel(),
    author = author.asModel(),
    episodeList = episodeList.map { it.asModel() },
    genre = genre
)

fun SeriesListResponse.asModel(): SeriesList = SeriesList(
    seriesList = seriesResponse.map { it.asModel() },
    hasMorePage = hasMorePage,
    currentPage = currentPage
)

fun SeriesResponse.asModel(): Series = Series(
    id = id,
    title = title,
    titleInfo = titleInfo.asModel(),
    dayOfWeek = dayOfWeek.asModel(),
    cycle = cycle.asModel(),
    genre = genre,
    author = author.asModel(),
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault())
)

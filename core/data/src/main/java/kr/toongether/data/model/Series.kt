package kr.toongether.data.model

import kr.toongether.model.Series
import kr.toongether.model.SeriesList
import kr.toongether.network.model.SeriesListResponse
import kr.toongether.network.model.SeriesResponse

fun SeriesResponse.asModel(): Series = Series(
    titleInfo = titleInfo.asModel(),
    author = author.asModel(),
    episodeList = episodeList.map { it.asModel() }
)

fun SeriesListResponse.asModel(): SeriesList = SeriesList(
    id = id,
    title = title,
    titleInfo = titleInfo.asModel(),
    dayOfWeek = dayOfWeek.asModel(),
    cycle = cycle.asModel(),
    genre = genre,
    author = author.asModel(),
    createdDate = createdDate,
    hasMorePage = hasMorePage,
    currentPage = currentPage
)

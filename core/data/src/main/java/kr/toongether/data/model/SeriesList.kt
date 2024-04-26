package kr.toongether.data.model

import kr.toongether.model.SeriesList
import kr.toongether.network.model.SeriesListResponse

internal fun SeriesListResponse.asModel() = SeriesList(
    series = seriesResponse.map { it.asModel() },
    hasMorePage = hasMorePage,
    currentPage = currentPage,
)

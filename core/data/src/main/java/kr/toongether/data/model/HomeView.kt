package kr.toongether.data.model

import kr.toongether.model.HomeView
import kr.toongether.model.Series
import kr.toongether.model.ViewType
import kr.toongether.network.model.HomeViewResponse
import kr.toongether.network.model.SeriesResponse
import kr.toongether.network.model.ShortsResponse

internal fun HomeViewResponse.asModel() = HomeView(
    type = type.asViewType(),
    children = (children as List<*>).map { child ->
        when (child) {
            is SeriesResponse -> child.asModel()
            is ShortsResponse -> child.asModel()
            else -> child!!
        }
    }
)

internal fun String.asViewType() = when (this) {
    ViewType.SERIES_BANNER.name -> ViewType.SERIES_BANNER
    ViewType.SERIES_CONTAINER.name -> ViewType.SERIES_CONTAINER
    ViewType.SHORTS_CONTAINER.name -> ViewType.SHORTS_CONTAINER
    else -> ViewType.SERIES_BANNER
}
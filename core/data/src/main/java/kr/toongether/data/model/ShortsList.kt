package kr.toongether.data.model

import kr.toongether.model.ShortsList
import kr.toongether.network.model.ShortsListResponse

internal fun ShortsListResponse.asModel() = ShortsList(
    shorts = shortsResponse.map { it.asModel() },
    hasMorePage = hasMorePage,
    currentPage = currentPage,
)

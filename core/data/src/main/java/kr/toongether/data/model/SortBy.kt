package kr.toongether.data.model

import kr.toongether.model.SortBy

internal fun String.asSortBy() = when (this) {
    SortBy.LATELY.name -> SortBy.LATELY
    SortBy.LIKES.name -> SortBy.LIKES
    else -> SortBy.LATELY
}
package kr.toongether.model

import kotlinx.datetime.LocalDateTime

data class SeriesList(
    val seriesList: List<Series>,
    val hasMorePage: Boolean,
    val currentPage: Int
)

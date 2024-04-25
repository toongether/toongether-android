package kr.toongether.model

data class SeriesList(
    val series: List<Series>,
    val hasMorePage: Boolean,
    val currentPage: Int,
)

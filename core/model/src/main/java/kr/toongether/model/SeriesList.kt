package kr.toongether.model

data class SeriesList(
    val seriesList: List<Series>,
    val hasMorePage: Boolean,
    val currentPage: Int
)

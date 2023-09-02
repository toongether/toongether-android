package kr.toongether.series

import kr.toongether.model.SeriesList

data class SeriesState(
    val seriesList: SeriesList = SeriesList(emptyList(), false, 1),
    val isLoading: Boolean = false
)

sealed class SeriesSideEffect {
    data class Toast(val text: String) : SeriesSideEffect()
}

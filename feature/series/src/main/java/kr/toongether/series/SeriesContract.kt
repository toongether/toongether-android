package kr.toongether.series

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.model.Series

data class SeriesState(
    val seriesList: Flow<PagingData<Series>>,
    val isLoading: Boolean = false
)

sealed class SeriesSideEffect {
    data class Toast(val text: String) : SeriesSideEffect()
}

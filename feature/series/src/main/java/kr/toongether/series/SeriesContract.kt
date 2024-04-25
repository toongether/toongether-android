package kr.toongether.series

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

data class SeriesState(
    val allSeries: Flow<PagingData<Series>>,
    val mondaySeries: Flow<PagingData<Series>>,
    val tuesdaySeries: Flow<PagingData<Series>>,
    val wednesdaySeries: Flow<PagingData<Series>>,
    val thursdaySeries: Flow<PagingData<Series>>,
    val fridaySeries: Flow<PagingData<Series>>,
    val saturdaySeries: Flow<PagingData<Series>>,
    val sundaySeries: Flow<PagingData<Series>>,
    val isLoading: Boolean = false
)

sealed class SeriesSideEffect {
    data class Toast(val text: String) : SeriesSideEffect()
}

package kr.toongether.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kr.toongether.domain.GetPagingSeriesUseCase
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Series
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getPagingSeriesUseCase: GetPagingSeriesUseCase
) : ContainerHost<SeriesState, SeriesSideEffect>, ViewModel() {

    override val container =
        container<SeriesState, SeriesSideEffect>(SeriesState(getPagingSeries(null, null)))

    fun getPagingSeries(dayOfWeek: DayOfWeek?, cycle: Cycle?): Flow<PagingData<Series>> =
        getPagingSeriesUseCase.invoke(
            dayOfWeek = dayOfWeek,
            cycle = cycle
        ).cachedIn(viewModelScope)
}

package kr.toongether.series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetPagingSeriesUseCase
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getPagingSeriesUseCase: GetPagingSeriesUseCase
) : ContainerHost<SeriesState, SeriesSideEffect>, ViewModel() {

    override val container =
        container<SeriesState, SeriesSideEffect>(
            SeriesState(
                getPagingSeriesUseCase.invoke(null, null).cachedIn(viewModelScope),
                getPagingSeriesUseCase.invoke(null, DayOfWeek.MONDAY).cachedIn(viewModelScope),
                getPagingSeriesUseCase.invoke(null, DayOfWeek.TUESDAY).cachedIn(viewModelScope),
                getPagingSeriesUseCase.invoke(null, DayOfWeek.WEDNESDAY).cachedIn(viewModelScope),
                getPagingSeriesUseCase.invoke(null, DayOfWeek.THURSDAY).cachedIn(viewModelScope),
                getPagingSeriesUseCase.invoke(null, DayOfWeek.FRIDAY).cachedIn(viewModelScope),
                getPagingSeriesUseCase.invoke(null, DayOfWeek.SATURDAY).cachedIn(viewModelScope),
                getPagingSeriesUseCase.invoke(null, DayOfWeek.SUNDAY).cachedIn(viewModelScope),
            )
        )

    fun fetchPagingSeries(dayOfWeek: DayOfWeek? = null, cycle: Cycle? = null) = intent {
        when (dayOfWeek) {
            DayOfWeek.MONDAY -> reduce {
                state.copy(
                    mondaySeries = getPagingSeriesUseCase.invoke(null, DayOfWeek.MONDAY)
                        .cachedIn(viewModelScope)
                )
            }
            DayOfWeek.TUESDAY -> reduce {
                state.copy(
                    tuesdaySeries = getPagingSeriesUseCase.invoke(null, DayOfWeek.TUESDAY)
                        .cachedIn(viewModelScope)
                )
            }
            DayOfWeek.WEDNESDAY -> reduce {
                state.copy(
                    wednesdaySeries = getPagingSeriesUseCase.invoke(null, DayOfWeek.WEDNESDAY)
                        .cachedIn(viewModelScope)
                )
            }
            DayOfWeek.THURSDAY -> reduce {
                state.copy(
                    thursdaySeries = getPagingSeriesUseCase.invoke(null, DayOfWeek.THURSDAY)
                        .cachedIn(viewModelScope)
                )
            }
            DayOfWeek.FRIDAY -> reduce {
                state.copy(
                    fridaySeries = getPagingSeriesUseCase.invoke(null, DayOfWeek.FRIDAY)
                        .cachedIn(viewModelScope)
                )
            }
            DayOfWeek.SATURDAY -> reduce {
                state.copy(
                    saturdaySeries = getPagingSeriesUseCase.invoke(null, DayOfWeek.SATURDAY)
                        .cachedIn(viewModelScope)
                )
            }
            DayOfWeek.SUNDAY -> reduce {
                state.copy(
                    sundaySeries = getPagingSeriesUseCase.invoke(null, DayOfWeek.SUNDAY)
                        .cachedIn(viewModelScope)
                )
            }
            else -> reduce {
                state.copy(
                    allSeries = getPagingSeriesUseCase.invoke(null, null)
                        .cachedIn(viewModelScope)
                )
            }
        }
    }
}

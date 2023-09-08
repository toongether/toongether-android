package kr.toongether.series

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetPagingSeriesUseCase
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val getPagingSeriesUseCase: GetPagingSeriesUseCase
) : ContainerHost<SeriesState, SeriesSideEffect>, ViewModel() {

    override val container =
        container<SeriesState, SeriesSideEffect>(
            SeriesState(
                getPagingSeriesUseCase.invoke(
                    null,
                    null
                )
            )
        )

    init {
        getPagingSeries(LocalDate.now().dayOfWeek.value)
    }

    fun getPagingSeries(today: Int? = null, cycle: Cycle? = null) = intent {
        reduce {
            state.copy(
                today = today ?: 0,
                seriesList = getPagingSeriesUseCase.invoke(
                    dayOfWeek = when (today) {
                        1 -> DayOfWeek.MONDAY
                        2 -> DayOfWeek.TUESDAY
                        3 -> DayOfWeek.WEDNESDAY
                        4 -> DayOfWeek.THURSDAY
                        5 -> DayOfWeek.FRIDAY
                        6 -> DayOfWeek.SATURDAY
                        7 -> DayOfWeek.SUNDAY
                        else -> null
                    },
                    cycle = cycle
                )
            )
        }
    }
}

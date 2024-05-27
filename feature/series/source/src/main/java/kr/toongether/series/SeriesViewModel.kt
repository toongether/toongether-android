package kr.toongether.series

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.datetime.toKotlinLocalDateTime
import kr.toongether.data.SeriesRepository
import kr.toongether.model.DayOfWeek
import kr.toongether.model.PublishStatus
import kr.toongether.seriesinterface.SeriesUiState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val seriesRepository: SeriesRepository
) : ContainerHost<SeriesUiState, Unit>, ViewModel() {

    override val container = container<SeriesUiState, Unit>(SeriesUiState.Loading)

    init {
        intent {
            seriesRepository.getSeriesList()
                .onStart { reduce { SeriesUiState.Loading } }
                .catch { reduce { SeriesUiState.Error(it.message.orEmpty()) } }
                .onEach { seriesList ->
                    val series = listOf(
                        seriesList.series.filter {
                            it.createdDate >= LocalDateTime.now().minusMonths(1)
                                .toKotlinLocalDateTime()
                        },
                        seriesList.series.filter { it.dayOfWeek == DayOfWeek.MONDAY },
                        seriesList.series.filter { it.dayOfWeek == DayOfWeek.TUESDAY },
                        seriesList.series.filter { it.dayOfWeek == DayOfWeek.WEDNESDAY },
                        seriesList.series.filter { it.dayOfWeek == DayOfWeek.THURSDAY },
                        seriesList.series.filter { it.dayOfWeek == DayOfWeek.FRIDAY },
                        seriesList.series.filter { it.dayOfWeek == DayOfWeek.SATURDAY },
                        seriesList.series.filter { it.dayOfWeek == DayOfWeek.SUNDAY },
                        seriesList.series.filter { it.publishStatus == PublishStatus.COMPLETED }
                    )
                    reduce { SeriesUiState.Success(series) }
                }
                .collect()
        }
    }

//    fun fetchSeries(dayOfWeek: DayOfWeek, page: Int, limit: Int) = intent {
//        seriesRepository.getSeriesList(
//            dayOfWeek = dayOfWeek,
//            page = page,
//            limit = limit,
//        )
//            .onStart { reduce { SeriesUiState.Loading } }
//            .catch { reduce { SeriesUiState.Error(it.message.orEmpty()) } }
//            .onEach { reduce { SeriesUiState.Success(it) }
//            .collect()
//    }
}



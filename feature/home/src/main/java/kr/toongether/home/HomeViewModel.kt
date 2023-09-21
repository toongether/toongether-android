package kr.toongether.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetSeriesListUseCase
import kr.toongether.domain.GetShortsListUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSeriesUseCase: GetSeriesListUseCase,
    private val getShortsListUseCase: GetShortsListUseCase,
) : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {

    override val container = container<HomeState, HomeSideEffect>(HomeState())

    init {
        getSeries()
        getShorts()
    }

    fun getSeries() = intent {
        reduce { state.copy(isLoading = true) }
        getSeriesUseCase(null, null, 1)
            .onSuccess {
                reduce {
                    state.copy(
                        seriesList = it.seriesList,
                        titleBanner = it.seriesList[0],
                        isLoading = false
                    )
                }
            }.onFailure {
                postSideEffect(HomeSideEffect.Toast(it.message!!))
            }
    }

    fun getShorts() = intent {
        reduce { state.copy(isLoading = true) }
        getShortsListUseCase(1)
            .onSuccess {
                reduce {
                    state.copy(
                        shortsList = it.shortsList.sortedByDescending { it.likeCount },
                        isLoading = false
                    )
                }
            }.onFailure {
                postSideEffect(HomeSideEffect.Toast(it.message!!))
            }
    }
}
package kr.toongether.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kr.toongether.data.HomeRepository
import kr.toongether.homeinterface.HomeSideEffect
import kr.toongether.homeinterface.HomeState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {

    override val container = container<HomeState, HomeSideEffect>(HomeState())

    init {
        getHomeView()
    }

    fun getHomeView() = intent {
        homeRepository.getHomeView()
            .onStart { reduce { state.copy(isLoading = true) } }
            .onEach {
                reduce {
                    state.copy(
                        homeViews = it,
                        isLoading = false
                    )
                }
            }
            .catch { reduce { state.copy(isLoading = false) } }
            .collect()
    }
}

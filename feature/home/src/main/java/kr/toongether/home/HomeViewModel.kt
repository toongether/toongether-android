package kr.toongether.home

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetComicViewUseCase
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
    private val getComicViewUseCase: GetComicViewUseCase
) : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {

    override val container = container<HomeState, HomeSideEffect>(HomeState(emptyList()))

    init {
        getComicView()
    }

    fun getComicView() = intent {
        reduce {
            state.copy(
                isLoading = true
            )
        }
        getComicViewUseCase()
            .onSuccess {
                Log.d("SUCCESS", it.toString())
                reduce {
                    state.copy(
                        isLoading = false,
                        viewList = it,
                    )
                }
            }.onFailure {
                Log.e("FAILURE", it.message.toString(), )
            }

    }
}

package kr.toongether.comic

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetComicListUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val getComicListUseCase: GetComicListUseCase
) : ContainerHost<ComicState, ComicSideEffect>, ViewModel() {

    override val container = container<ComicState, ComicSideEffect>(ComicState())

    init {
//        getComicList(id)
    }

    fun getComicList(id: Long) = intent {
        reduce {
            state.copy(isLoading = true)
        }
        getComicListUseCase.invoke(id)
            .onSuccess {
                reduce {
                    state.copy(
                        isLoading = false,
                        comicList = it
                    )
                }
            }.onFailure {
                postSideEffect(ComicSideEffect.Toast("서버 연결에 실패했습니다."))
                reduce {
                    state.copy(
                        error = it,
                        isLoading = false
                    )
                }
            }
    }
}
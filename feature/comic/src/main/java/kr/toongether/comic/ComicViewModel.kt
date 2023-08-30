package kr.toongether.comic

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetShortsEpisodeUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val getShortsEpisodeUseCase: GetShortsEpisodeUseCase
) : ContainerHost<ComicState, ComicSideEffect>, ViewModel() {

    override val container = container<ComicState, ComicSideEffect>(ComicState())

    init {
//        getComicList(id)
    }

    fun getComicList(id: Long) = intent {
        reduce {
            state.copy(isLoading = true)
        }
        getShortsEpisodeUseCase.invoke(id)
            .onSuccess {
                reduce {
                    state.copy(
                        isLoading = false,
                        comic = it
                    )
                }
            }.onFailure {
                postSideEffect(ComicSideEffect.Toast(it.message!!))
                reduce {
                    state.copy(
                        error = it,
                        isLoading = false
                    )
                }
            }
    }
}

package kr.toongether.shorts.genre.prerelease

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetShortsListUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class PreReleaseViewModel @Inject constructor(
    private val getShortsListUseCase: GetShortsListUseCase
) : ContainerHost<PreReleaseState, PreReleaseSideEffect>, ViewModel() {

    override val container = container<PreReleaseState, PreReleaseSideEffect>(PreReleaseState())

    init {
        getShortsList()
    }

    fun getShortsList() = intent {
        reduce {
            state.copy(isLoading = true)
        }
        getShortsListUseCase.invoke()
            .onSuccess {
                reduce {
                    state.copy(
                        isLoading = false,
                        webtoonList = it
                    )
                }
            }.onFailure {
                postSideEffect(PreReleaseSideEffect.Toast("서버 연결에 실패했습니다."))
                reduce {
                    state.copy(
                        isLoading = false,
                        error = it
                    )
                }
            }
    }
}

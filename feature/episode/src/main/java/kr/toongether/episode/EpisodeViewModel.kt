package kr.toongether.episode

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetSeriesUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val getSeriesUseCase: GetSeriesUseCase
) : ContainerHost<EpisodeState, EpisodeSideEffect>, ViewModel() {

    override val container = container<EpisodeState, EpisodeSideEffect>(EpisodeState())

    fun getSeriesEpisode(id: Long) = intent {
        reduce {
            state.copy(
                isLoading = true
            )
        }

        getSeriesUseCase.invoke(id = id)
            .onSuccess {
                reduce {
                    state.copy(
                        seriesEpisodeList = it,
                        isLoading = false
                    )
                }
            }.onFailure {
                postSideEffect(EpisodeSideEffect.Toast(it.message!!))
                reduce {
                    state.copy(
                        isLoading = false
                    )
                }
            }
    }
}

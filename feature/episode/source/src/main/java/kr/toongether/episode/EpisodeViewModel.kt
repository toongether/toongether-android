package kr.toongether.episode

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kr.toongether.data.SeriesRepository
import kr.toongether.episodeinterface.EpisodeSideEffect
import kr.toongether.episodeinterface.EpisodeUiState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val seriesRepository: SeriesRepository
) : ContainerHost<EpisodeUiState, EpisodeSideEffect>, ViewModel() {

    override val container = container<EpisodeUiState, EpisodeSideEffect>(EpisodeUiState.Loading)

    fun getSeriesEpisodeList(id: Long) = intent {
        seriesRepository.getSeriesEpisodeList(id)
            .onStart { reduce { EpisodeUiState.Loading } }
            .catch {
                postSideEffect(EpisodeSideEffect.Toast(it.message!!))
            }
            .onEach {
                reduce {
                    EpisodeUiState.Success(data = it)
                }
            }
            .collect()
    }
}

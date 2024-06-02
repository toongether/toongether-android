package kr.toongether.comic

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kr.toongether.comicinterface.ComicSideEffect
import kr.toongether.comicinterface.ComicUiState
import kr.toongether.common.network.exception.BadRequestException
import kr.toongether.common.network.exception.UnauthorizedException
import kr.toongether.data.LikeRepository
import kr.toongether.data.SeriesRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val likeRepository: LikeRepository,
) : ContainerHost<ComicUiState, ComicSideEffect>, ViewModel() {

    override val container = container<ComicUiState, ComicSideEffect>(ComicUiState.Loading)

    fun getComic(seriesId: Long, episodeId: Long) = intent {
        seriesRepository.getSeriesEpisode(seriesId, episodeId)
            .onStart { reduce { ComicUiState.Loading } }
            .catch { reduce { ComicUiState.Error("에피소드를 불러오는데 실패했습니다.") } }
            .onEach { reduce { ComicUiState.Success(episode = it) } }
            .collect()
    }

    fun like(seriesEpisodeId: Long) = intent {
        likeRepository.likeSeries(seriesEpisodeId)
            .catch {
                if (it is UnauthorizedException || it is BadRequestException) {
                    postSideEffect(ComicSideEffect.NavigateToLogin)
                } else {
                    reduce { ComicUiState.Error("좋아요 실패") }
                }
            }
            .onEach {
                val episode = (state as ComicUiState.Success).episode
                reduce {
                    ComicUiState.Success(
                        episode.copy(
                            liked = it,
                            likeCount = if (it) episode.likeCount + 1 else episode.likeCount - 1
                        )
                    )
                }
            }
            .collect()
    }
}

package kr.toongether.comic

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kr.toongether.comicinterface.ComicSideEffect
import kr.toongether.comicinterface.ComicState
import kr.toongether.data.LikeRepository
import kr.toongether.data.SeriesRepository
import kr.toongether.data.ShortsRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val shortsRepository: ShortsRepository,
    private val likeRepository: LikeRepository,
) : ContainerHost<ComicState, ComicSideEffect>, ViewModel() {

    override val container = container<ComicState, ComicSideEffect>(ComicState.Loading)

    fun getComic(id: Long) = intent {
        shortsRepository.getShorts(id)
            .onStart { reduce { ComicState.Loading } }
            .onEach {
                reduce {
                    ComicState.Success(shorts = it)
                }
            }
            .collect()
    }

    fun getComic(seriesId: Long, episodeId: Long) = intent {
        seriesRepository.getSeriesEpisode(seriesId, episodeId)
            .onStart { reduce { ComicState.Loading } }
            .onEach {
                reduce {
                    ComicState.Success(episode = it)
                }
            }
            .collect()
    }

    fun likeShorts(shortsId: Long) = intent {
        likeRepository.likeShorts(shortsId)
            .onEach {
                val state = state as ComicState.Success
                if (it) {
                    ComicState.Success(shorts = state.shorts?.copy(
                        liked = true,
                        likeCount = state.shorts?.likeCount!!.plus(1)
                    ))
                } else {
                    ComicState.Success(shorts = state.shorts?.copy(
                        liked = false,
                        likeCount = state.shorts?.likeCount!!.minus(1)
                    ))
                }
            }
            .catch {
                if (it.message.toString().contains("400")) {
                    postSideEffect(ComicSideEffect.LoginToast)
                } else {
                    postSideEffect(ComicSideEffect.Toast(it.message!!))
                }
            }
            .collect()
    }

    fun likeSeries(seriesId: Long) = intent {
        likeRepository.likeSeries(seriesId)
            .onEach {
                val state = state as ComicState.Success
                if (it) {
                    ComicState.Success(episode = state.episode?.copy(
                        liked = true,
                        likeCount = state.episode?.likeCount!!.plus(1)
                    ))
                } else {
                    ComicState.Success(episode = state.episode?.copy(
                        liked = false,
                        likeCount = state.episode?.likeCount!!.minus(1)
                    ))
                }
            }
            .catch {
                if (it.message.toString().contains("400")) {
                    postSideEffect(ComicSideEffect.LoginToast)
                } else {
                    postSideEffect(ComicSideEffect.Toast(it.message!!))
                }
            }
            .collect()
    }
}

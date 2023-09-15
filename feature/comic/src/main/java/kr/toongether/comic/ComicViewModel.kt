package kr.toongether.comic

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.toongether.domain.GetSeriesEpisodeUseCase
import kr.toongether.domain.GetShortsEpisodeUseCase
import kr.toongether.domain.LikeSeriesUseCase
import kr.toongether.domain.LikeShortsUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val getShortsEpisodeUseCase: GetShortsEpisodeUseCase,
    private val getSeriesEpisodeUseCase: GetSeriesEpisodeUseCase,
    private val likeShortsUseCase: LikeShortsUseCase,
    private val likeSeriesUseCase: LikeSeriesUseCase,
) : ContainerHost<ComicState, ComicSideEffect>, ViewModel() {

    override val container = container<ComicState, ComicSideEffect>(ComicState())

    fun getComic(id: Long) = intent {
        reduce {
            state.copy(isLoading = true)
        }
        getShortsEpisodeUseCase.invoke(id)
            .onSuccess {
                reduce {
                    state.copy(
                        isLoading = false,
                        comic = it,
                        liked = it.liked,
                        likeCount = it.likeCount
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

    fun getComic(seriesId: Long, episodeId: Long) = intent {
        reduce {
            state.copy(isLoading = true)
        }
        getSeriesEpisodeUseCase.invoke(
            seriesId = seriesId,
            episodeId = episodeId
        ).onSuccess {
            reduce {
                state.copy(
                    isLoading = false,
                    comic = it,
                    liked = it.liked,
                    likeCount = it.likeCount
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

    fun likeShorts(shortsId: Long) = intent {
        likeShortsUseCase.invoke(shortsId)
            .onSuccess {
                if (it) {
                    reduce { state.copy(likeCount = state.likeCount + 1, liked = true) }
                } else {
                    reduce { state.copy(likeCount = state.likeCount - 1, liked = false) }
                }
            }.onFailure {
                postSideEffect(ComicSideEffect.Toast(it.message!!))
            }
    }

    fun likeSeries(seriesId: Long) = intent {
        likeSeriesUseCase.invoke(seriesId)
            .onSuccess {
                if (it) {
                    reduce { state.copy(likeCount = state.likeCount + 1, liked = true) }
                } else {
                    reduce { state.copy(likeCount = state.likeCount - 1, liked = false) }
                }
            }.onFailure {
                postSideEffect(ComicSideEffect.Toast(it.message!!))
            }
    }
}

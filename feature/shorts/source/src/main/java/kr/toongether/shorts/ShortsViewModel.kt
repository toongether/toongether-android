package kr.toongether.shorts

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kr.toongether.common.network.exception.BadRequestException
import kr.toongether.common.network.exception.UnauthorizedException
import kr.toongether.data.LikeRepository
import kr.toongether.data.ShortsRepository
import kr.toongether.shortsinterface.ShortsSideEffect
import kr.toongether.shortsinterface.ShortsUiState
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ShortsViewModel @Inject constructor(
    private val shortsRepository: ShortsRepository,
    private val likeRepository: LikeRepository,
) : ContainerHost<ShortsUiState, ShortsSideEffect>, ViewModel() {

    override val container = container<ShortsUiState, ShortsSideEffect>(ShortsUiState.Loading)

    init {
        intent {
            shortsRepository.getShortsList()
                .onStart { reduce { ShortsUiState.Loading } }
                .catch { reduce { ShortsUiState.Error(it.message.toString()) } }
                .onEach {
                    val shortsList = it.shorts.shuffled()
                    val shortsDetails = List(shortsList.size) { index ->
                        shortsRepository.getShorts(shortsList[index].id).first()
                    }
                    reduce { ShortsUiState.Success(shortsList, shortsDetails) }
                }
                .collect()
        }
    }

    fun like(shortsId: Long, index: Int) = intent {
        likeRepository.likeShorts(shortsId)
            .catch {
                if (it is UnauthorizedException || it is BadRequestException) {
                    postSideEffect(ShortsSideEffect.NavigateToLogin)
                } else {
                    reduce { ShortsUiState.Error("좋아요 실패") }
                }
            }
            .onEach { liked ->
                val shorts = (state as ShortsUiState.Success)
                reduce {
                    ShortsUiState.Success(
                        shorts = shorts.shorts.map {
                            if (it.id == shorts.shorts[index].id) {
                                it.copy(
                                    liked = liked,
                                    likeCount = if (liked) it.likeCount.plus(1) else it.likeCount.minus(1)
                                )
                            } else {
                                it
                            }
                        },
                        shortsList = shorts.shortsList
                    )
                }
            }
            .collect()
    }
}

//package kr.toongether.comic
//
//import androidx.lifecycle.ViewModel
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.catch
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.flow.onEach
//import kotlinx.coroutines.flow.onStart
//import kr.toongether.data.LikeRepository
//import kr.toongether.data.SeriesRepository
//import kr.toongether.data.ShortsRepository
//import org.orbitmvi.orbit.ContainerHost
//import org.orbitmvi.orbit.syntax.simple.intent
//import org.orbitmvi.orbit.syntax.simple.postSideEffect
//import org.orbitmvi.orbit.syntax.simple.reduce
//import org.orbitmvi.orbit.viewmodel.container
//import javax.inject.Inject
//
//@HiltViewModel
//class ComicViewModel @Inject constructor(
//    private val seriesRepository: SeriesRepository,
//    private val shortsRepository: ShortsRepository,
//    private val likeRepository: LikeRepository,
//) : ContainerHost<ComicState, ComicSideEffect>, ViewModel() {
//
//    override val container = container<ComicState, ComicSideEffect>(ComicState())
//
//    fun getComic(id: Long) = intent {
//        shortsRepository.getShorts(id)
//            .onStart { reduce { state.copy(isLoading = true) } }
//            .onEach {
//                reduce {
//                    state.copy(
//                        isLoading = false,
//                        comic = it,
//                        liked = it.liked,
//                        likeCount = it.likeCount
//                    )
//                }
//            }
//            .catch {
//                postSideEffect(ComicSideEffect.Toast(it.message!!))
//                reduce {
//                    state.copy(
//                        isLoading = false
//                    )
//                }
//            }
//            .collect()
//    }
//
//    fun getComic(seriesId: Long, episodeId: Long) = intent {
//        seriesRepository.getSeriesEpisode(seriesId, episodeId)
//            .onStart { reduce { state.copy(isLoading = true) } }
//            .onEach {
//                reduce {
//                    state.copy(
//                        isLoading = false,
//                        comic = it,
//                        liked = it.liked,
//                        likeCount = it.likeCount
//                    )
//                }
//            }
//            .catch {
//                postSideEffect(ComicSideEffect.Toast(it.message!!))
//                reduce {
//                    state.copy(
//                        isLoading = false
//                    )
//                }
//            }
//            .collect()
//    }
//
//    fun likeShorts(shortsId: Long) = intent {
//        likeRepository.likeShorts(shortsId)
//            .onEach {
//                if (it) {
//                    reduce { state.copy(likeCount = state.likeCount + 1, liked = true) }
//                } else {
//                    reduce { state.copy(likeCount = state.likeCount - 1, liked = false) }
//                    postSideEffect(ComicSideEffect.LoginToast)
//                }
//            }
//            .catch {
//                if (it.message.toString().contains("400")) {
//                    postSideEffect(ComicSideEffect.LoginToast)
//                } else {
//                    postSideEffect(ComicSideEffect.Toast(it.message!!))
//                }
//            }
//            .collect()
//    }
//
//    fun likeSeries(seriesId: Long) = intent {
//        likeRepository.likeSeries(seriesId)
//            .onEach {
//                if (it) {
//                    reduce { state.copy(likeCount = state.likeCount + 1, liked = true) }
//                } else {
//                    reduce { state.copy(likeCount = state.likeCount - 1, liked = false) }
//                }
//            }
//            .catch {
//                if (it.message.toString().contains("400")) {
//                    postSideEffect(ComicSideEffect.LoginToast)
//                } else {
//                    postSideEffect(ComicSideEffect.Toast(it.message!!))
//                }
//            }
//            .collect()
//    }
//}

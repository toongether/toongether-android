package kr.toongether.comicinterface

import kr.toongether.model.EpisodeDetail
import kr.toongether.model.ShortsDetail

sealed interface ComicState {
    data class Success(
        val shorts: ShortsDetail? = null,
        val episode: EpisodeDetail? = null
    ) : ComicState
    object Loading : ComicState
}

sealed interface ComicSideEffect {
    object Like : ComicSideEffect
    object UnLike : ComicSideEffect
    data class Toast(val text: String) : ComicSideEffect
    object LoginToast : ComicSideEffect
}

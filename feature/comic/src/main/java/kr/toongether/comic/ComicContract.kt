package kr.toongether.comic

import kr.toongether.model.ComicList


data class ComicState(
    val comicList: ComicList = ComicList(emptyList(), 0, 0, 0, 0),
    val error: Throwable? = null,
    val isLoading: Boolean = false,
)

sealed class ComicSideEffect {
    data class Toast(val text: String) : ComicSideEffect()
}

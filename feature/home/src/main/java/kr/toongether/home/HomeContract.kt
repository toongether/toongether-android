package kr.toongether.home

import kr.toongether.model.ComicView

data class HomeState(
    val viewList: List<ComicView>,
    val isLoading: Boolean = false
)

sealed class HomeSideEffect {
    data class Toast(val text: String) : HomeSideEffect()
}

package kr.toongether.shorts.genre.prerelease

import kr.toongether.model.Shorts

data class PreReleaseState(
    val webtoonList: List<Shorts> = emptyList(),
    val error: Throwable? = null,
    val isLoading: Boolean = false,
    val isRefresh: Boolean = false,
)

sealed class PreReleaseSideEffect {
    data class Toast(val text: String) : PreReleaseSideEffect()
}
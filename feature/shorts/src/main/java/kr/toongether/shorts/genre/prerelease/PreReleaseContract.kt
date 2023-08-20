package kr.toongether.shorts.genre.prerelease

import kr.toongether.model.Shorts

data class PreReleaseState(
    val shortsList: List<Shorts> = emptyList(),
    val isLoading: Boolean = false
)

sealed class PreReleaseSideEffect {
    data class Toast(val text: String) : PreReleaseSideEffect()
}

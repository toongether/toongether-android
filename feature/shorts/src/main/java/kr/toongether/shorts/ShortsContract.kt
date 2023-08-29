package kr.toongether.shorts

data class ShortsState(
    val isLoading: Boolean = false
)

sealed class ShortsSideEffect {
    data class Toast(val text: String) : ShortsSideEffect()
}

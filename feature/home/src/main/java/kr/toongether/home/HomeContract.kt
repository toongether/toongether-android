package kr.toongether.home

data class HomeState(
    val seriesList: List<Series> = emptyList(),
    val shortsList: List<Shorts> = emptyList(),
    val titleBanner: Series? = null,
    val isLoading: Boolean = false
)

sealed class HomeSideEffect {
    data class Toast(val text: String) : HomeSideEffect()
}

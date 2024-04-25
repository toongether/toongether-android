package kr.toongether.episode

data class EpisodeState(
    val seriesEpisodeList: SeriesEpisodeList = SeriesEpisodeList(
        cycle = Cycle.WEEKLY,
        dayOfWeek = DayOfWeek.SUNDAY,
        titleInfo = TitleInfo(
            color = "#000000",
            titleWidth = 0f,
            titleImage = "",
            thumbnailImage = ""
        ),
        author = Author(
            id = 0,
            name = "",
            profileImage = null
        ),
        episodeList = emptyList(),
        genre = ""
    ),
    val isLoading: Boolean = false
)

sealed class EpisodeSideEffect {
    data class Toast(val text: String) : EpisodeSideEffect()
}

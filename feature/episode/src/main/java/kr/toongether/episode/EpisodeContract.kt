package kr.toongether.episode

import kr.toongether.model.Author
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import kr.toongether.model.SeriesEpisodeList
import kr.toongether.model.TitleInfo

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

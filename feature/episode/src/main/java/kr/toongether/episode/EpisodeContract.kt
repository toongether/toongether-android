package kr.toongether.episode

import kr.toongether.model.Author
import kr.toongether.model.DayOfWeek
import kr.toongether.model.PublishStatus
import kr.toongether.model.SerialCycle
import kr.toongether.model.SeriesEpisodeList
import kr.toongether.model.TitleMaker

data class EpisodeState(
    val seriesEpisodeList: SeriesEpisodeList = SeriesEpisodeList(
        serialCycle = SerialCycle.WEEKLY,
        dayOfWeek = DayOfWeek.SUNDAY,
        titleMaker = TitleMaker(
            color = "#000000",
            titleSvg = "",
            backgroundImage = ""
        ),
        author = Author(
            id = 0,
            name = "",
            profileImage = ""
        ),
        episodeList = emptyList(),
        description = "",
        publishStatus = PublishStatus.ON_GOING,
        genre = emptyList(),
        title = ""
    ),
    val isLoading: Boolean = false
)

sealed class EpisodeSideEffect {
    data class Toast(val text: String) : EpisodeSideEffect()
}

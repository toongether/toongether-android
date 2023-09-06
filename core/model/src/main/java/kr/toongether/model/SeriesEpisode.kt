package kr.toongether.model

data class SeriesEpisode(
    val cycle: Cycle,
    val dayOfWeek: DayOfWeek,
    val genre: String,
    val titleInfo: TitleInfo,
    val author: Author,
    val episodeList: List<Episode>
)

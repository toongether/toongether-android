package kr.toongether.model

data class SeriesEpisodeList(
    val title: String,
    val description: String,
    val titleMaker: TitleMaker,
    val publishStatus: PublishStatus,
    val dayOfWeek: DayOfWeek,
    val serialCycle: SerialCycle,
    val genre: List<String>,
    val author: Author,
    val episodeList: List<Episode>,
)

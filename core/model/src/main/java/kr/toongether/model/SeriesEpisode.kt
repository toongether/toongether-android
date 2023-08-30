package kr.toongether.model

data class SeriesEpisode(
    val titleInfo: TitleInfo,
    val author: Author,
    val episodeList: List<Episode>
)

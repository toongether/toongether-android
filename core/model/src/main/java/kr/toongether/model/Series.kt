package kr.toongether.model

data class Series(
    val titleInfo: TitleInfo,
    val author: Author,
    val episodeList: List<Episode>
)

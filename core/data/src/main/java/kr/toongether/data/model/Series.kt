package kr.toongether.data.model

import kr.toongether.model.Series
import kr.toongether.network.model.SeriesResponse

fun SeriesResponse.asModel(): Series = Series(
    titleInfo = titleInfo.asModel(),
    author = author.asModel(),
    episodeList = episodeList.map { it.asModel() },
)
package kr.toongether.data.model

import kr.toongether.model.TitleInfo
import kr.toongether.network.model.TitleMakerResponse

fun TitleMakerResponse.asModel(): TitleInfo = TitleInfo(
    color = color,
    titleWidth = titleWidth,
    titleImage = titleImage,
    thumbnailImage = thumbnailImage
)

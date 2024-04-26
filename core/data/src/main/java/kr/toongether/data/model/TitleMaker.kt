package kr.toongether.data.model

import kr.toongether.model.TitleMaker
import kr.toongether.network.model.TitleMakerResponse

internal fun TitleMakerResponse.asModel() = TitleMaker(
    color = color,
    titleSvg = titleSvg,
    backgroundImage = backgroundImage,
)
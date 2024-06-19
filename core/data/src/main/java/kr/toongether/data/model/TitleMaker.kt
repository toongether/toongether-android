package kr.toongether.data.model

import kr.toongether.model.TitleMaker
import kr.toongether.network.model.TitleMakerEpisodeResponse
import kr.toongether.network.model.TitleMakerResponse

internal fun TitleMakerResponse.asModel() = TitleMaker(
    color = color,
    alignCenterTitleSvg = titleSvg,
    backgroundImage = backgroundImage,
)

internal fun TitleMakerEpisodeResponse.asModel() = TitleMaker(
    color = color,
    alignLeftTitleSvg = alignLeftTitleSvg,
    alignCenterTitleSvg = alignCenterTitleSvg,
    backgroundImage = backgroundImage,
)
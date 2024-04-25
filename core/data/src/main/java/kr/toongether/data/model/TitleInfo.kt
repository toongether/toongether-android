package kr.toongether.data.model

fun TitleMakerResponse.asModel(): TitleInfo = TitleInfo(
    color = color,
    titleWidth = titleWidth,
    titleImage = titleImage,
    thumbnailImage = thumbnailImage
)

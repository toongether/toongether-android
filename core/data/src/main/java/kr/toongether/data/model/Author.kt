package kr.toongether.data.model

fun NetworkAuthor.asModel(): Author = Author(
    id = id,
    name = name,
    profileImage = profileImage
)

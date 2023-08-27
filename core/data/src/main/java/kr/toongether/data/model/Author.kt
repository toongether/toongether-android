package kr.toongether.data.model

import kr.toongether.model.Author
import kr.toongether.network.model.NetworkAuthor

fun NetworkAuthor.asModel(): Author = Author(
    id = id,
    name = name,
    profileImage = profileImage,
)
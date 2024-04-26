package kr.toongether.data.model

import kr.toongether.model.Author
import kr.toongether.network.model.NetworkAuthor

internal fun NetworkAuthor.asModel() = Author(
    id = id,
    name = name,
    profileImage = profileImage,
)
package kr.toongether.data.model

import kr.toongether.model.User
import kr.toongether.network.model.UserResponse

fun UserResponse.asModel(): User = User(
    id = id,
    userId = userId,
    email = email,
    name = name,
    profileImage = profileImage ?: ""
)

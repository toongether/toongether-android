package kr.toongether.data.model

fun UserResponse.asModel(): User = User(
    id = id,
    userId = userId,
    email = email,
    name = name,
    profileImage = profileImage ?: ""
)

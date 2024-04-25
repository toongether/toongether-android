package kr.toongether.model

data class LoginToken(
    val accessToken: String,
    val refreshToken: String,
)

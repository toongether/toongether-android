package kr.toongether.data.model

import kr.toongether.model.Login
import kr.toongether.model.Token
import kr.toongether.network.model.LoginRequest
import kr.toongether.network.model.TokenResponse

fun Login.asRequest() = LoginRequest(
    userId = userId,
    password = password,
)

fun TokenResponse.asModel() = Token(
    accessToken = accessToken,
    refreshToken = refreshToken,
)

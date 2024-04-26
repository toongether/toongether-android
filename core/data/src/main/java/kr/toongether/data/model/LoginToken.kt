package kr.toongether.data.model

import kr.toongether.model.LoginToken
import kr.toongether.network.model.LoginTokenResponse

internal fun LoginTokenResponse.asModel() = LoginToken(
    accessToken = accessToken,
    refreshToken = refreshToken,
)

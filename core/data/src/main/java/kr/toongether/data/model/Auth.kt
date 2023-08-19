package kr.toongether.data.model

import kr.toongether.model.CheckEmail
import kr.toongether.model.Email
import kr.toongether.model.Login
import kr.toongether.model.Signup
import kr.toongether.model.Token
import kr.toongether.network.model.CheckEmailRequest
import kr.toongether.network.model.EmailRequest
import kr.toongether.network.model.LoginRequest
import kr.toongether.network.model.SignupRequest
import kr.toongether.network.model.TokenResponse

fun Login.asRequest() = LoginRequest(
    userId = userId,
    password = password
)

fun TokenResponse.asModel() = Token(
    accessToken = accessToken,
    refreshToken = refreshToken
)

fun Signup.asRequest() = SignupRequest(
    userId = userId,
    password = password,
    name = name,
    email = email,
    code = code
)

fun Email.asRequest() = EmailRequest(
    email = email
)

fun CheckEmail.asRequest() = CheckEmailRequest(
    code = code
)

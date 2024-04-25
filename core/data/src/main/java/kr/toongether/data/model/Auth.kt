package kr.toongether.data.model

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

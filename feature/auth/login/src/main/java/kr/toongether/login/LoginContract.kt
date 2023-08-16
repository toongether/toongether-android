package kr.toongether.login

import kr.toongether.model.Token

data class LoginState(
    val token: Token = Token("", ""),
    val error: Throwable? = null,
    val isLoading: Boolean = false
)

sealed class LoginSideEffect {
    data class Toast(val text: String) : LoginSideEffect()
}

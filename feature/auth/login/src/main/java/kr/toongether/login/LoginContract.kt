package kr.toongether.login

data class LoginState(
    val isLoading: Boolean = false
)

sealed class LoginSideEffect {
    data class Toast(val text: String) : LoginSideEffect()
    object NavigateToMy : LoginSideEffect()
}

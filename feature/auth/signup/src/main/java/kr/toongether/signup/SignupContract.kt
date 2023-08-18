package kr.toongether.signup

data class SignupState(
    val isEmailChecked: Boolean = false,
    val error: Throwable? = null,
    val isLoading: Boolean = false
)

sealed class SignupSideEffect {
    data class Toast(val text: String) : SignupSideEffect()
    object NavigateToCheckEmail : SignupSideEffect()
    object NavigateToInputPassword : SignupSideEffect()
}
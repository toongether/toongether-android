package kr.toongether.my

import kr.toongether.model.User

data class MyState(
    val userInfo: User = User(
        id = 0,
        userId = "",
        email = "",
        name = "",
        profileImage = ""
    ),
    val isLoading: Boolean = false
)

sealed class MySideEffect {
    data class Toast(val text: String) : MySideEffect()
    object NavigateToLogin : MySideEffect()
}

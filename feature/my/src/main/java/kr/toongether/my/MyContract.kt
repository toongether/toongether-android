package kr.toongether.my

import kr.toongether.model.UserInfo

data class MyState(
    val userInfo: UserInfo = UserInfo(
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
    object NavigateToMy : MySideEffect()
}

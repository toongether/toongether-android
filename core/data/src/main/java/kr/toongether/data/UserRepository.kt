package kr.toongether.data

import kr.toongether.model.Email
import kr.toongether.model.Login
import kr.toongether.model.Signup
import kr.toongether.model.Token
import kr.toongether.model.User

interface UserRepository {
    suspend fun login(
        login: Login
    ): Token

    suspend fun signup(
        signup: Signup
    )

    suspend fun sendEmail(
        email: Email
    )

    suspend fun checkEmail(
        email: String,
        code: String
    ): Boolean

    suspend fun getUser(): User
}

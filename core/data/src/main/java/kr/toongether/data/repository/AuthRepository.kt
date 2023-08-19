package kr.toongether.data.repository

import kr.toongether.model.CheckEmail
import kr.toongether.model.Email
import kr.toongether.model.Login
import kr.toongether.model.Signup
import kr.toongether.model.Token

interface AuthRepository {
    suspend fun login(login: Login): Token
    suspend fun signup(signup: Signup)
    suspend fun sendEmail(email: Email)
    suspend fun checkEmail(checkEmail: CheckEmail): Boolean
}

package kr.toongether.data.repository

import kr.toongether.model.Login
import kr.toongether.model.Token

interface AuthRepository {
    suspend fun login(login: Login): Token
}
package kr.toongether.network

import kr.toongether.network.model.LoginRequest
import kr.toongether.network.model.TokenResponse

interface ToongetherAuthNetworkDataSource {
    suspend fun login(loginRequest: LoginRequest): TokenResponse
}
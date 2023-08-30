package kr.toongether.network.datasource

import kr.toongether.network.model.EmailRequest
import kr.toongether.network.model.LoginRequest
import kr.toongether.network.model.SignupRequest
import kr.toongether.network.model.TokenResponse
import kr.toongether.network.model.UserResponse

interface UserNetworkDataSource {
    suspend fun signup(
        signupRequest: SignupRequest
    )

    suspend fun login(
        loginRequest: LoginRequest
    ): TokenResponse

    suspend fun sendEmail(
        emailRequest: EmailRequest
    )

    suspend fun checkEmail(
        email: String,
        code: String
    ): Boolean

    suspend fun getUser(
        id: Long
    ): UserResponse
}

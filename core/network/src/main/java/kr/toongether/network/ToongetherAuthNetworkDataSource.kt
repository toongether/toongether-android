package kr.toongether.network

import kr.toongether.network.model.CheckEmailRequest
import kr.toongether.network.model.EmailRequest
import kr.toongether.network.model.LoginRequest
import kr.toongether.network.model.SignupRequest
import kr.toongether.network.model.TokenResponse

interface ToongetherAuthNetworkDataSource {
    suspend fun login(loginRequest: LoginRequest): TokenResponse
    suspend fun signup(signupRequest: SignupRequest)
    suspend fun sendEmail(emailRequest: EmailRequest)
    suspend fun checkEmail(checkEmailRequest: CheckEmailRequest): Boolean
}

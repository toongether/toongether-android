package kr.toongether.domain

import kr.toongether.data.repository.AuthRepository
import kr.toongether.model.Login
import kr.toongether.model.Token
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(login: Login): Result<Token> = kotlin.runCatching {
        authRepository.login(login)
    }
}
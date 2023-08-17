package kr.toongether.domain

import kr.toongether.data.repository.AuthRepository
import kr.toongether.model.Signup
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(signup: Signup): Result<Unit> = kotlin.runCatching {
        authRepository.signup(signup)
    }
}
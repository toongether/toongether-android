package kr.toongether.domain

import kr.toongether.data.repository.AuthRepository
import kr.toongether.model.CheckEmail
import javax.inject.Inject

class CheckEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(checkEmail: CheckEmail): Result<Boolean> = kotlin.runCatching {
        authRepository.checkEmail(checkEmail)
    }
}

package kr.toongether.domain

import kr.toongether.data.repository.AuthRepository
import kr.toongether.model.Email
import javax.inject.Inject

class SendEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: Email): Result<Unit> = kotlin.runCatching {
        authRepository.sendEmail(email)
    }
}

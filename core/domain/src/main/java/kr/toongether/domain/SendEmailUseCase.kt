package kr.toongether.domain

import kr.toongether.data.UserRepository
import kr.toongether.model.Email
import javax.inject.Inject

class SendEmailUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(email: Email): Result<Unit> = kotlin.runCatching {
        repository.sendEmail(email)
    }
}

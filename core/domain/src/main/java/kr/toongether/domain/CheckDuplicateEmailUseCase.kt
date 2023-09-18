package kr.toongether.domain

import kr.toongether.data.UserRepository
import javax.inject.Inject

class CheckDuplicateEmailUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(email: String) = kotlin.runCatching {
        repository.checkDuplicateEmail(email)
    }
}
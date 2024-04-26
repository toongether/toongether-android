package kr.toongether.domain

import javax.inject.Inject

class CheckDuplicateUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: String) = kotlin.runCatching {
        repository.checkDuplicateUser(userId)
    }
}

package kr.toongether.domain

import kr.toongether.data.UserRepository
import javax.inject.Inject

class CheckDuplicateUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: String) = kotlin.runCatching {
        repository.checkDuplicateUser(userId)
    }
}

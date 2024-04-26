package kr.toongether.domain

import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): Result<User> = kotlin.runCatching {
        repository.getUser()
    }
}

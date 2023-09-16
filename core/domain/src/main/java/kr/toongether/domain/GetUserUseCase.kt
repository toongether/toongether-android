package kr.toongether.domain

import kr.toongether.data.UserRepository
import kr.toongether.model.User
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): Result<User> = kotlin.runCatching {
        repository.getUser()
    }
}

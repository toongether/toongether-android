package kr.toongether.domain

import kr.toongether.data.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        repository.deleteUser()
    }
}
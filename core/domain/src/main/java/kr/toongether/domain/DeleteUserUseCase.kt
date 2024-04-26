package kr.toongether.domain

import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        repository.deleteUser()
    }
}

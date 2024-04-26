package kr.toongether.domain

import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(signup: Signup): Result<Unit> = kotlin.runCatching {
        repository.signup(signup)
    }
}

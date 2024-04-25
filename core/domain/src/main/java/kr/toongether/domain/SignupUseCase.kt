package kr.toongether.domain

import kr.toongether.data.UserRepository
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(signup: Signup): Result<Unit> = kotlin.runCatching {
        repository.signup(signup)
    }
}

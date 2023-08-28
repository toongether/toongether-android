package kr.toongether.domain

import kr.toongether.data.UserRepository
import javax.inject.Inject

class CheckEmailUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(
        email: String,
        code: String
    ): Result<Boolean> = kotlin.runCatching {
        repository.checkEmail(
            email = email,
            code = code
        )
    }
}

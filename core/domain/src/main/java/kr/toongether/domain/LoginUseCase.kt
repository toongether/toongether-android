package kr.toongether.domain

import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(login: Login): Result<Token> = kotlin.runCatching {
        repository.login(login)
    }
}

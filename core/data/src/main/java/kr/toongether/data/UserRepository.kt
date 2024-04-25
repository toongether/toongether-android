package kr.toongether.data

interface UserRepository {
    suspend fun login(
        login: Login
    ): Token

    suspend fun signup(
        signup: Signup
    )

    suspend fun sendEmail(
        email: Email
    )

    suspend fun checkEmail(
        email: String,
        code: String
    ): Boolean

    suspend fun getUser(): User

    suspend fun deleteUser()

    suspend fun checkDuplicateUser(
        userId: String
    ): Boolean

    suspend fun checkDuplicateEmail(
        email: String
    ): Boolean
}

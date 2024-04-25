package kr.toongether.data.repository

import kr.toongether.data.UserRepository
import kr.toongether.data.model.asModel
import kr.toongether.data.model.asRequest
import kr.toongether.network.datasource.UserNetworkDataSource
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val network: UserNetworkDataSource
) : UserRepository {
    override suspend fun login(login: Login): Token =
        network.login(login.asRequest()).asModel()

    override suspend fun signup(signup: Signup) =
        network.signup(signup.asRequest())

    override suspend fun sendEmail(email: Email) =
        network.sendEmail(email.asRequest())

    override suspend fun checkEmail(email: String, code: String): Boolean =
        network.checkEmail(email, code)

    override suspend fun getUser(): User =
        network.getUser().asModel()

    override suspend fun deleteUser() =
        network.deleteUser()

    override suspend fun checkDuplicateUser(userId: String): Boolean =
        network.checkDuplicateUser(userId)

    override suspend fun checkDuplicateEmail(email: String): Boolean =
        network.checkDuplicateEmail(email)
}

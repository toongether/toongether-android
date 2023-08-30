package kr.toongether.data.repository

import kr.toongether.data.UserRepository
import kr.toongether.data.model.asModel
import kr.toongether.data.model.asRequest
import kr.toongether.model.Email
import kr.toongether.model.Login
import kr.toongether.model.Signup
import kr.toongether.model.Token
import kr.toongether.model.User
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

    override suspend fun getUser(id: Long): User =
        network.getUser(id).asModel()
}

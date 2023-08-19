package kr.toongether.data.repository

import kr.toongether.data.model.asModel
import kr.toongether.data.model.asRequest
import kr.toongether.model.CheckEmail
import kr.toongether.model.Email
import kr.toongether.model.Login
import kr.toongether.model.Signup
import kr.toongether.model.Token
import kr.toongether.network.ToongetherAuthNetworkDataSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val network: ToongetherAuthNetworkDataSource
) : AuthRepository {
    override suspend fun login(login: Login): Token =
        network.login(login.asRequest()).asModel()

    override suspend fun signup(signup: Signup) =
        network.signup(signup.asRequest())

    override suspend fun sendEmail(email: Email) =
        network.sendEmail(email.asRequest())

    override suspend fun checkEmail(checkEmail: CheckEmail): Boolean =
        network.checkEmail(checkEmail.asRequest())
}

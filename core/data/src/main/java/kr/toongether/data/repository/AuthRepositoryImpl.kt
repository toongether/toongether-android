package kr.toongether.data.repository

import kr.toongether.data.model.asModel
import kr.toongether.data.model.asRequest
import kr.toongether.model.Login
import kr.toongether.model.Token
import kr.toongether.network.ToongetherAuthNetworkDataSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val network: ToongetherAuthNetworkDataSource
) : AuthRepository {
    override suspend fun login(login: Login): Token =
        network.login(login.asRequest()).asModel()

}
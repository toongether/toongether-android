package kr.toongether.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.toongether.common.network.Dispatcher
import kr.toongether.common.network.ToongetherDispatcher
import kr.toongether.data.UserRepository
import kr.toongether.data.model.asModel
import kr.toongether.model.LoginToken
import kr.toongether.model.UserInfo
import kr.toongether.network.datasource.UserNetworkDataSource
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val network: UserNetworkDataSource,
    @Dispatcher(ToongetherDispatcher.IO) private val dispatcher: CoroutineDispatcher,
) : UserRepository {
    override suspend fun signup(
        userId: String,
        password: String,
        name: String,
        email: String,
        code: String
    ) {
        network.signup(userId, password, name, email, code)
    }

    override fun refreshToken(refreshToken: String): Flow<String> {
        return flow {
            emit(network.refreshToken(refreshToken))
        }.flowOn(dispatcher)
    }

    override fun login(userId: String, password: String): Flow<LoginToken> {
        return flow {
            emit(network.login(userId, password).asModel())
        }.flowOn(dispatcher)
    }

    override suspend fun changePassword(
        existingPassword: String,
        changePassword: String,
        checkChangePassword: String
    ) {
        network.changePassword(existingPassword, changePassword, checkChangePassword)
    }

    override fun validateUser(userId: String): Flow<Boolean> {
        return flow {
            emit(network.validateUser(userId))
        }.flowOn(dispatcher)
    }

    override fun getUserInfo(): Flow<UserInfo> {
        return flow {
            emit(network.getUserInfo().asModel())
        }.flowOn(dispatcher)
    }

    override suspend fun deleteUser() {
        network.deleteUser()
    }
}

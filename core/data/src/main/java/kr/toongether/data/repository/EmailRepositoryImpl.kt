package kr.toongether.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.toongether.common.network.Dispatcher
import kr.toongether.common.network.ToongetherDispatcher
import kr.toongether.data.EmailRepository
import kr.toongether.network.datasource.EmailNetworkDataSource
import javax.inject.Inject

internal class EmailRepositoryImpl @Inject constructor(
    private val network: EmailNetworkDataSource,
    @Dispatcher(ToongetherDispatcher.IO) private val dispatcher: CoroutineDispatcher,
) : EmailRepository {
    override suspend fun sendEmail(email: String) {
        network.sendEmail(email)
    }

    override fun validateEmail(email: String): Flow<Boolean> {
        return flow {
            emit(network.validateEmail(email))
        }.flowOn(dispatcher)
    }

    override fun checkEmail(email: String, code: String): Flow<Boolean> {
        return flow {
            emit(network.checkEmail(email, code))
        }.flowOn(dispatcher)
    }
}

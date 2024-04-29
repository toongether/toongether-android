package kr.toongether.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.toongether.common.network.Dispatcher
import kr.toongether.common.network.ToongetherDispatcher
import kr.toongether.data.HomeRepository
import kr.toongether.data.model.asModel
import kr.toongether.model.HomeView
import kr.toongether.network.datasource.HomeNetworkDataSource
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val network: HomeNetworkDataSource,
    @Dispatcher(ToongetherDispatcher.IO) private val dispatcher: CoroutineDispatcher,
) : HomeRepository {
    override fun getHomeView(): Flow<List<HomeView>> {
        return flow {
            emit(network.getHomeView().map { it.asModel() })
        }.flowOn(dispatcher)
    }
}

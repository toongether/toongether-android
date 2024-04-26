package kr.toongether.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.toongether.common.network.Dispatcher
import kr.toongether.common.network.ToongetherDispatcher
import kr.toongether.data.LikeRepository
import kr.toongether.network.datasource.LikeNetworkDataSource
import javax.inject.Inject

internal class LikeRepositoryImpl @Inject constructor(
    private val network: LikeNetworkDataSource,
    @Dispatcher(ToongetherDispatcher.IO) private val dispatcher: CoroutineDispatcher,
) : LikeRepository {
    override fun likeShorts(shortsId: Long): Flow<Boolean> {
        return flow {
            emit(network.likeShorts(shortsId))
        }.flowOn(dispatcher)
    }

    override fun likeSeries(seriesEpisodeId: Long): Flow<Boolean> {
        return flow {
            emit(network.likeSeries(seriesEpisodeId))
        }.flowOn(dispatcher)
    }
}

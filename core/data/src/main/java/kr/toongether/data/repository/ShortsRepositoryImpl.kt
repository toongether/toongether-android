package kr.toongether.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kr.toongether.common.network.Dispatcher
import kr.toongether.common.network.ToongetherDispatcher
import kr.toongether.data.ShortsRepository
import kr.toongether.data.model.asModel
import kr.toongether.data.paging.MyShortsPagingSource
import kr.toongether.data.paging.ShortsPagingSource
import kr.toongether.model.Shorts
import kr.toongether.model.ShortsDetail
import kr.toongether.model.ShortsList
import kr.toongether.model.SortBy
import kr.toongether.network.datasource.ShortsNetworkDataSource
import javax.inject.Inject

internal class ShortsRepositoryImpl @Inject constructor(
    private val network: ShortsNetworkDataSource,
    @Dispatcher(ToongetherDispatcher.IO) private val dispatcher: CoroutineDispatcher,
) : ShortsRepository {
    override fun getShorts(shortsId: Long): Flow<ShortsDetail> {
        return flow {
            emit(network.getShorts(shortsId).asModel())
        }.flowOn(dispatcher)
    }

    override fun getMyShortsList(page: Int, limit: Int): Flow<PagingData<Shorts>> {
        return Pager(
            config = PagingConfig(pageSize = limit, enablePlaceholders = false),
            pagingSourceFactory = { MyShortsPagingSource(page, limit, network) }
        ).flow.map {
            it.map { pagingData ->
                pagingData.asModel()
            }
        }.flowOn(dispatcher)
    }

    override fun getPagingShortsList(sortBy: SortBy, page: Int, limit: Int): Flow<PagingData<Shorts>> {
        return Pager(
            config = PagingConfig(pageSize = limit, enablePlaceholders = false),
            pagingSourceFactory = { ShortsPagingSource(sortBy.name, page, limit, network) }
        ).flow.map {
            it.map { pagingData ->
                pagingData.asModel()
            }
        }.flowOn(dispatcher)
    }

    override fun getShortsList(sortBy: SortBy, page: Int, limit: Int): Flow<ShortsList> {
        return flow {
            emit(network.getShortsList(sortBy.name, page, limit).asModel())
        }.flowOn(dispatcher)
    }

}

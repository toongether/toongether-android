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
import kr.toongether.data.CommentRepository
import kr.toongether.data.model.asModel
import kr.toongether.data.paging.CommentsPagingSource
import kr.toongether.data.paging.ShortsPagingSource
import kr.toongether.model.Comment
import kr.toongether.model.CommentList
import kr.toongether.network.datasource.CommentNetworkDataSource
import javax.inject.Inject

internal class CommentRepositoryImpl @Inject constructor(
    private val network: CommentNetworkDataSource,
    @Dispatcher(ToongetherDispatcher.IO) private val dispatcher: CoroutineDispatcher
) : CommentRepository {
    override fun getComments(episodeId: Long, page: Int): Flow<PagingData<Comment>> {
        return Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { CommentsPagingSource(episodeId, page, network) }
        ).flow.map {
            it.map { pagingData ->
                pagingData.asModel()
            }
        }.flowOn(dispatcher)
    }
}
package kr.toongether.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.toongether.network.datasource.CommentNetworkDataSource
import kr.toongether.network.datasource.ShortsNetworkDataSource
import kr.toongether.network.model.CommentListResponse
import kr.toongether.network.model.CommentResponse
import kr.toongether.network.model.SeriesResponse
import java.io.IOException

internal class CommentsPagingSource(
    private val episodeId: Long,
    private val page: Int,
    private val network: CommentNetworkDataSource
) : PagingSource<Int, CommentResponse>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CommentResponse> {
        return try {
            val response = network.getComments(
                page = page,
                episodeId = episodeId
            )
            LoadResult.Page(
                data = response.commentResponse,
                prevKey = null,
                nextKey = if (response.hasMorePage) page.plus(1) else null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CommentResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

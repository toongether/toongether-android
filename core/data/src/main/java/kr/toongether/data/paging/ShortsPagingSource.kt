package kr.toongether.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.toongether.network.datasource.ShortsNetworkDataSource
import kr.toongether.network.model.ShortsResponse
import java.io.IOException

internal class ShortsPagingSource(
    private val sortBy: String,
    private val page: Int,
    private val limit: Int,
    private val network: ShortsNetworkDataSource
) : PagingSource<Int, ShortsResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShortsResponse> {
        return try {
            val response = network.getShortsList(
                sortBy = sortBy,
                page = page,
                limit = limit,
            )
            LoadResult.Page(
                data = response.shortsResponse,
                prevKey = null,
                nextKey = if (response.hasMorePage) page.plus(1) else null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ShortsResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

package kr.toongether.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.toongether.network.datasource.ComicNetworkDataSource
import kr.toongether.network.model.ShortsListResponse
import kr.toongether.network.model.ShortsResponse

internal class ShortsPagingDataSource(
    private val network: ComicNetworkDataSource
) : PagingSource<Int, ShortsResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShortsResponse> {
        val page = params.key ?: 1
        return try {
            val response = network.getShortsList(page = page)
            LoadResult.Page(
                data = response.shortsResponse,
                prevKey = null,
                nextKey = if (response.shortsResponse.isEmpty()) null else page.plus(1)
            )
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

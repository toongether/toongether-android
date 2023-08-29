package kr.toongether.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.toongether.network.datasource.ComicNetworkDataSource
import kr.toongether.network.model.ShortsListResponse

internal class ShortsPagingDataSource(
    private val network: ComicNetworkDataSource
) : PagingSource<Int, ShortsListResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShortsListResponse> {
        val page = params.key ?: 1
        return try {
            val response = network.getShortsList(page = page)
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ShortsListResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

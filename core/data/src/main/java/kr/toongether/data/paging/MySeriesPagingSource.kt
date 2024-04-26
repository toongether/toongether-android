package kr.toongether.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.toongether.network.datasource.SeriesNetworkDataSource
import kr.toongether.network.model.SeriesResponse
import java.io.IOException

internal class MySeriesPagingSource(
    private val page: Int,
    private val limit: Int,
    private val network: SeriesNetworkDataSource
) : PagingSource<Int, SeriesResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SeriesResponse> {
        return try {
            val response = network.getMySeries(
                page = page,
                limit = limit,
            )
            LoadResult.Page(
                data = response.seriesResponse,
                prevKey = null,
                nextKey = if (response.hasMorePage) page.plus(1) else null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SeriesResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

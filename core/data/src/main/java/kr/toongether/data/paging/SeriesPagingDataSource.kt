package kr.toongether.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.toongether.network.datasource.ComicNetworkDataSource
import kr.toongether.network.model.NetworkCycle
import kr.toongether.network.model.NetworkDayOfWeek
import kr.toongether.network.model.SeriesResponse
import java.io.IOException

internal class SeriesPagingDataSource(
    private val dayOfWeek: NetworkDayOfWeek?,
    private val cycle: NetworkCycle?,
    private val network: ComicNetworkDataSource
) : PagingSource<Int, SeriesResponse>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SeriesResponse> {
        val page = params.key ?: 1
        return try {
            val response = network.getSeriesList(
                page = page,
                dayOfWeek = dayOfWeek,
                cycle = cycle
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

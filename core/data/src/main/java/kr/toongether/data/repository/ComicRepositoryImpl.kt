package kr.toongether.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kr.toongether.data.ComicRepository
import kr.toongether.data.model.asModel
import kr.toongether.data.model.asRequest
import kr.toongether.data.paging.SeriesPagingDataSource
import kr.toongether.data.paging.ShortsPagingDataSource
import kr.toongether.model.Comic
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Series
import kr.toongether.model.SeriesEpisode
import kr.toongether.model.SeriesList
import kr.toongether.model.Shorts
import kr.toongether.model.ShortsList
import kr.toongether.network.datasource.ComicNetworkDataSource
import javax.inject.Inject

internal class ComicRepositoryImpl @Inject constructor(
    private val network: ComicNetworkDataSource
) : ComicRepository {
    override suspend fun getShortsList(page: Int): ShortsList =
        network.getShortsList(page).asModel()

    override suspend fun getShortsEpisode(id: Long): Comic =
        network.getShortsEpisode(id).asModel()

    override suspend fun getSeriesList(
        dayOfWeek: DayOfWeek?,
        cycle: Cycle?,
        page: Int
    ): SeriesList =
        network.getSeriesList(
            dayOfWeek = dayOfWeek?.asRequest(),
            cycle = cycle?.asRequest(),
            page = page
        ).asModel()

    override suspend fun getSeries(id: Long): SeriesEpisode =
        network.getSeries(id).asModel()

    override suspend fun getSeriesEpisode(seriesId: Long, episodeId: Long): Comic =
        network.getSeriesEpisode(seriesId, episodeId).asModel()

    override fun getPagingShorts(): Flow<PagingData<Shorts>> =
        Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { ShortsPagingDataSource(network) }
        ).flow.map {
            it.map { pagingData ->
                pagingData.asModel()
            }
        }

    override fun getPagingSeries(cycle: Cycle?, dayOfWeek: DayOfWeek?): Flow<PagingData<Series>> =
        Pager(
            config = PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = {
                SeriesPagingDataSource(
                    network = network,
                    cycle = cycle?.asRequest(),
                    dayOfWeek = dayOfWeek?.asRequest()
                )
            }
        ).flow.map {
            it.map { pagingData ->
                pagingData.asModel()
            }
        }
}

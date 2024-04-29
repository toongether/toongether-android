package kr.toongether.data.repository

import android.util.Log
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
import kr.toongether.data.SeriesRepository
import kr.toongether.data.model.asModel
import kr.toongether.data.paging.MySeriesPagingSource
import kr.toongether.data.paging.SeriesPagingSource
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Episode
import kr.toongether.model.SerialCycle
import kr.toongether.model.Series
import kr.toongether.model.SeriesEpisodeList
import kr.toongether.model.SeriesList
import kr.toongether.network.datasource.SeriesNetworkDataSource
import javax.inject.Inject

internal class SeriesRepositoryImpl @Inject constructor(
    private val network: SeriesNetworkDataSource,
    @Dispatcher(ToongetherDispatcher.IO) private val dispatcher: CoroutineDispatcher,
) : SeriesRepository {
    override fun getMySeries(page: Int, limit: Int): Flow<PagingData<Series>> {
        return Pager(
            config = PagingConfig(pageSize = limit, enablePlaceholders = false),
            pagingSourceFactory = { MySeriesPagingSource(page, limit, network) }
        ).flow.map {
            it.map { pagingData ->
                pagingData.asModel()
            }
        }.flowOn(dispatcher)
    }

    override fun getPagingSeriesList(
        dayOfWeek: DayOfWeek?,
        serialCycle: SerialCycle?,
        page: Int,
        limit: Int
    ): Flow<PagingData<Series>> {
        return Pager(
            config = PagingConfig(pageSize = limit, enablePlaceholders = false),
            pagingSourceFactory = {
                SeriesPagingSource(
                    dayOfWeek?.name,
                    serialCycle?.name,
                    page,
                    limit,
                    network
                )
            }
        ).flow.map {
            it.map { seriesResponse ->
                seriesResponse.asModel()
            }
        }.flowOn(dispatcher)
    }

    override fun getSeriesList(
        dayOfWeek: DayOfWeek?,
        serialCycle: SerialCycle?,
        page: Int,
        limit: Int
    ): Flow<SeriesList> {
        return flow {
            emit(network.getSeriesList(dayOfWeek?.name, serialCycle?.name, page, limit).asModel())
        }.flowOn(dispatcher)
    }

    override fun getSeriesEpisodeList(seriesId: Long): Flow<SeriesEpisodeList> {
        return flow {
            emit(network.getSeriesEpisodeList(seriesId).asModel())
        }.flowOn(dispatcher)
    }

    override fun getSeriesEpisode(seriesId: Long, episodeNumber: Long): Flow<Episode> {
        return flow {
            emit(network.getSeriesEpisode(seriesId, episodeNumber).asModel())
        }.flowOn(dispatcher)
    }

    override fun getMySeriesEpisodeList(seriesId: Long): Flow<SeriesEpisodeList> {
        return flow {
            emit(network.getMySeriesEpisodeList(seriesId).asModel())
        }.flowOn(dispatcher)
    }

}

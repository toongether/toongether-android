package kr.toongether.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Episode
import kr.toongether.model.EpisodeDetail
import kr.toongether.model.SerialCycle
import kr.toongether.model.Series
import kr.toongether.model.SeriesEpisodeList
import kr.toongether.model.SeriesList

interface SeriesRepository {
    fun getMySeries(
        page: Int = 1,
        limit: Int = 10,
    ): Flow<PagingData<Series>>

    fun getPagingSeriesList(
        dayOfWeek: DayOfWeek? = null,
        serialCycle: SerialCycle? = null,
        page: Int = 1,
        limit: Int = 10,
    ): Flow<PagingData<Series>>

    fun getSeriesList(
        dayOfWeek: DayOfWeek? = null,
        serialCycle: SerialCycle? = null,
        page: Int = 1,
        limit: Int = 10,
    ): Flow<SeriesList>

    fun getSeriesEpisodeList(
        seriesId: Long,
    ): Flow<SeriesEpisodeList>

    fun getSeriesEpisode(
        seriesId: Long,
        episodeNumber: Long,
    ): Flow<EpisodeDetail>

    fun getMySeriesEpisodeList(
        seriesId: Long,
    ): Flow<SeriesEpisodeList>
}

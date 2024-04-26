package kr.toongether.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Episode
import kr.toongether.model.SerialCycle
import kr.toongether.model.Series
import kr.toongether.model.SeriesEpisodeList
import kr.toongether.model.SeriesList

interface SeriesRepository {
    fun getMySeries(
        page: Int,
        limit: Int,
    ): Flow<PagingData<Series>>

    fun getSeriesList(
        dayOfWeek: DayOfWeek,
        serialCycle: SerialCycle,
        page: Int,
        limit: Int,
    ): Flow<PagingData<Series>>

    fun getSeriesEpisodeList(
        seriesId: Long,
    ): Flow<SeriesEpisodeList>

    fun getSeriesEpisode(
        seriesId: Long,
        episodeNumber: Long,
    ): Flow<Episode>

    fun getMySeriesEpisodeList(
        seriesId: Long,
    ): Flow<SeriesEpisodeList>
}

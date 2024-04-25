package kr.toongether.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface ComicRepository {
    suspend fun getShortsList(
        page: Int
    ): ShortsList

    suspend fun getShortsEpisode(
        id: Long
    ): Comic

    suspend fun getSeriesList(
        dayOfWeek: DayOfWeek?,
        cycle: Cycle?,
        page: Int
    ): SeriesList

    suspend fun getSeries(
        id: Long
    ): SeriesEpisodeList

    suspend fun getSeriesEpisode(
        seriesId: Long,
        episodeId: Long
    ): Comic

    fun getPagingShorts(): Flow<PagingData<Shorts>>

    fun getPagingSeries(cycle: Cycle?, dayOfWeek: DayOfWeek?): Flow<PagingData<Series>>

    suspend fun likeShorts(
        shortsId: Long
    ): Boolean

    suspend fun likeSeries(
        seriesId: Long
    ): Boolean
}

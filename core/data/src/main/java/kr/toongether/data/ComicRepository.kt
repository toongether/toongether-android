package kr.toongether.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.model.Comic
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Series
import kr.toongether.model.SeriesEpisodeList
import kr.toongether.model.SeriesList
import kr.toongether.model.Shorts
import kr.toongether.model.ShortsList

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

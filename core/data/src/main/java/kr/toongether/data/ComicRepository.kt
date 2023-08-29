package kr.toongether.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.model.Comic
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import kr.toongether.model.Series
import kr.toongether.model.SeriesList
import kr.toongether.model.ShortsList
import kr.toongether.network.model.NetworkCycle
import kr.toongether.network.model.NetworkDayOfWeek

interface ComicRepository {
    suspend fun getShortsList(
        page: Int,
    ): List<ShortsList>

    suspend fun getShortsEpisode(
        id: Long
    ): Comic

    suspend fun getSeriesList(
        dayOfWeek: DayOfWeek,
        cycle: Cycle,
        page: Int,
    ): List<SeriesList>

    suspend fun getSeries(
        id: Long
    ): Series

    suspend fun getSeriesEpisode(
        seriesId: Long,
        episodeId: Long,
    ): Comic

    fun getPagingShorts(): Flow<PagingData<ShortsList>>
}

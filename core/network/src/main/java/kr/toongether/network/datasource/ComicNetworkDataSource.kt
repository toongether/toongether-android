package kr.toongether.network.datasource

import kr.toongether.network.model.ComicResponse
import kr.toongether.network.model.NetworkCycle
import kr.toongether.network.model.NetworkDayOfWeek
import kr.toongether.network.model.SeriesListResponse
import kr.toongether.network.model.SeriesResponse
import kr.toongether.network.model.ShortsListResponse

interface ComicNetworkDataSource {
    suspend fun getShortsList(
        page: Int
    ): ShortsListResponse

    suspend fun getShortsEpisode(
        id: Long
    ): ComicResponse

    suspend fun getSeriesList(
        dayOfWeek: NetworkDayOfWeek,
        cycle: NetworkCycle,
        page: Int
    ): List<SeriesListResponse>

    suspend fun getSeries(
        id: Long
    ): SeriesResponse

    suspend fun getSeriesEpisode(
        seriesId: Long,
        episodeId: Long
    ): ComicResponse
}

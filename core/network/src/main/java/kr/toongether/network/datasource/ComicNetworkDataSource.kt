package kr.toongether.network.datasource

import kr.toongether.network.model.ComicResponse
import kr.toongether.network.model.NetworkCycle
import kr.toongether.network.model.NetworkDayOfWeek
import kr.toongether.network.model.SeriesEpisodeListResponse
import kr.toongether.network.model.SeriesListResponse
import kr.toongether.network.model.ShortsListResponse

interface ComicNetworkDataSource {
    suspend fun getShortsList(
        page: Int
    ): ShortsListResponse

    suspend fun getShortsEpisode(
        shortsId: Long
    ): ComicResponse

    suspend fun getSeriesList(
        dayOfWeek: NetworkDayOfWeek?,
        cycle: NetworkCycle?,
        page: Int
    ): SeriesListResponse

    suspend fun getSeries(
        seriesId: Long
    ): SeriesEpisodeListResponse

    suspend fun getSeriesEpisode(
        seriesId: Long,
        episodeId: Long
    ): ComicResponse

    suspend fun likeShorts(
        shortsId: Long
    ): Boolean

    suspend fun likeSeries(
        seriesId: Long
    ): Boolean
}

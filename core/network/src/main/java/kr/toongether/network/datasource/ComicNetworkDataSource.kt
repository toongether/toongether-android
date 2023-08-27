package kr.toongether.network.datasource

import kr.toongether.network.model.ComicResponse
import kr.toongether.network.model.EpisodeResponse
import kr.toongether.network.model.NetworkCycle
import kr.toongether.network.model.NetworkDayOfWeek
import kr.toongether.network.model.SeriesResponse
import kr.toongether.network.model.ShortsResponse

interface ComicNetworkDataSource {
    suspend fun getShortsList(
        page: Int,
    ): List<ShortsResponse>

    suspend fun getShortsEpisode(
        id: Long
    ): ComicResponse

    suspend fun getSeriesList(
        dayOfWeek: NetworkDayOfWeek,
        cycle: NetworkCycle,
        page: Int,
    ): List<SeriesResponse>

    suspend fun getSeries(
        id: Long
    ): EpisodeResponse

    suspend fun getSeriesEpisode(
        seriesId: Long,
        episodeId: Long,
    ): ComicResponse
}
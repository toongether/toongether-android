package kr.toongether.network.datasource

import kr.toongether.network.model.EpisodeDetailResponse
import kr.toongether.network.model.EpisodeResponse
import kr.toongether.network.model.SeriesEpisodeListResponse
import kr.toongether.network.model.SeriesListResponse

interface SeriesNetworkDataSource {
    suspend fun getMySeries(
        page: Int,
        limit: Int,
    ): SeriesListResponse

    suspend fun getSeriesList(
        dayOfWeek: String?,
        cycle: String?,
        page: Int,
        limit: Int,
    ): SeriesListResponse

    suspend fun getSeriesEpisodeList(
        seriesId: Long,
    ): SeriesEpisodeListResponse

    suspend fun getSeriesEpisode(
        seriesId: Long,
        episodeNumber: Long,
    ): EpisodeDetailResponse

    suspend fun getMySeriesEpisodeList(
        seriesId: Long,
    ): SeriesEpisodeListResponse
}

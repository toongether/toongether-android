package kr.toongether.network.api

import kr.toongether.network.model.ComicResponse
import kr.toongether.network.model.EpisodeResponse
import kr.toongether.network.model.NetworkCycle
import kr.toongether.network.model.NetworkDayOfWeek
import kr.toongether.network.model.SeriesResponse
import kr.toongether.network.model.ShortsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface ComicApi {
    @GET("comic/shorts/list")
    suspend fun getShortsList(
        @Query("page") page: Int,
    ): List<ShortsResponse>

    @GET("comic/shorts/{id}/episode")
    suspend fun getShortsEpisode(
        @Path("id") id: Long
    ): ComicResponse

    @GET("comic/series/list")
    suspend fun getSeriesList(
        @Query("dayOfWeek") dayOfWeek: NetworkDayOfWeek,
        @Query("cycle") cycle: NetworkCycle,
        @Query("page") page: Int,
    ): List<SeriesResponse>

    @GET("comic/series/{id}/episode")
    suspend fun getSeries(
        @Path("id") id: Long
    ): EpisodeResponse

    @GET("comic/series/{seriesId}/episode/{episodeId}")
    suspend fun getSeriesEpisode(
        @Path("seriesId") seriesId: Long,
        @Path("episodeId") episode: Long,
    ): ComicResponse
}
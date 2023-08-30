package kr.toongether.network.retrofit

import kr.toongether.common.network.networkHandler
import kr.toongether.network.datasource.ComicNetworkDataSource
import kr.toongether.network.model.ComicResponse
import kr.toongether.network.model.NetworkCycle
import kr.toongether.network.model.NetworkDayOfWeek
import kr.toongether.network.model.SeriesListResponse
import kr.toongether.network.model.SeriesEpisodeResponse
import kr.toongether.network.model.ShortsListResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitComicNetworkApi {
    @GET("comic/shorts/list")
    suspend fun getShortsList(
        @Query("page") page: Int
    ): ShortsListResponse

    @GET("comic/shorts/{id}/episode")
    suspend fun getShortsEpisode(
        @Path("id") id: Long
    ): ComicResponse

    @GET("comic/series/list")
    suspend fun getSeriesList(
        @Query("dayOfWeek") dayOfWeek: NetworkDayOfWeek,
        @Query("cycle") cycle: NetworkCycle,
        @Query("page") page: Int
    ): SeriesListResponse

    @GET("comic/series/{id}/episode")
    suspend fun getSeries(
        @Path("id") id: Long
    ): SeriesEpisodeResponse

    @GET("comic/series/{seriesId}/episode/{episodeId}")
    suspend fun getSeriesEpisode(
        @Path("seriesId") seriesId: Long,
        @Path("episodeId") episodeId: Long
    ): ComicResponse
}

@Singleton
internal class RetrofitComicNetwork @Inject constructor(
    retrofit: Retrofit
) : ComicNetworkDataSource {
    private val comicApi = retrofit.create(RetrofitComicNetworkApi::class.java)

    override suspend fun getShortsList(page: Int): ShortsListResponse = networkHandler {
        comicApi.getShortsList(page)
    }

    override suspend fun getShortsEpisode(id: Long): ComicResponse = networkHandler {
        comicApi.getShortsEpisode(id)
    }

    override suspend fun getSeriesList(
        dayOfWeek: NetworkDayOfWeek,
        cycle: NetworkCycle,
        page: Int
    ): SeriesListResponse = networkHandler {
        comicApi.getSeriesList(dayOfWeek, cycle, page)
    }

    override suspend fun getSeries(id: Long): SeriesEpisodeResponse = networkHandler {
        comicApi.getSeries(id)
    }

    override suspend fun getSeriesEpisode(
        seriesId: Long,
        episodeId: Long
    ): ComicResponse = networkHandler {
        comicApi.getSeriesEpisode(seriesId, episodeId)
    }
}

package kr.toongether.network.retrofit

import kr.toongether.common.network.networkHandler
import kr.toongether.network.datasource.ComicNetworkDataSource
import kr.toongether.network.model.ComicResponse
import kr.toongether.network.model.ComicViewResponse
import kr.toongether.network.model.NetworkCycle
import kr.toongether.network.model.NetworkDayOfWeek
import kr.toongether.network.model.SeriesEpisodeListResponse
import kr.toongether.network.model.SeriesListResponse
import kr.toongether.network.model.ShortsListResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitComicNetworkApi {
    @GET("comic/shorts/list")
    suspend fun getShortsList(
        @Query("page") page: Int
    ): ShortsListResponse

    @GET("comic/shorts/{shortsId}")
    suspend fun getShortsEpisode(
        @Path("shortsId") shortsId: Long
    ): ComicResponse

    @GET("comic/series/list")
    suspend fun getSeriesList(
        @Query("dayOfWeek") dayOfWeek: NetworkDayOfWeek?,
        @Query("cycle") cycle: NetworkCycle?,
        @Query("page") page: Int
    ): SeriesListResponse

    @GET("comic/series/episode/{seriesId}")
    suspend fun getSeries(
        @Path("seriesId") seriesId: Long
    ): SeriesEpisodeListResponse

    @GET("comic/series/episode/{seriesId}/{episodeId}")
    suspend fun getSeriesEpisode(
        @Path("seriesId") seriesId: Long,
        @Path("episodeId") episodeId: Long
    ): ComicResponse

    @POST("like/shorts/{shortsId}")
    suspend fun likeShorts(
        @Path("shortsId") shortsId: Long
    ): Boolean

    @POST("like/series/{seriesId}")
    suspend fun likeSeries(
        @Path("seriesId") seriesId: Long
    ): Boolean

    @POST("home/get/comic")
    suspend fun <T> getComicView(
    ): List<ComicViewResponse<T>>
}

@Singleton
internal class RetrofitComicNetwork @Inject constructor(
    retrofit: Retrofit
) : ComicNetworkDataSource {
    private val comicApi = retrofit.create(RetrofitComicNetworkApi::class.java)

    override suspend fun getShortsList(page: Int): ShortsListResponse = networkHandler {
        comicApi.getShortsList(page)
    }

    override suspend fun getShortsEpisode(shortsId: Long): ComicResponse = networkHandler {
        comicApi.getShortsEpisode(shortsId)
    }

    override suspend fun getSeriesList(
        dayOfWeek: NetworkDayOfWeek?,
        cycle: NetworkCycle?,
        page: Int
    ): SeriesListResponse = networkHandler {
        comicApi.getSeriesList(dayOfWeek, cycle, page)
    }

    override suspend fun getSeries(seriesId: Long): SeriesEpisodeListResponse = networkHandler {
        comicApi.getSeries(seriesId)
    }

    override suspend fun getSeriesEpisode(
        seriesId: Long,
        episodeId: Long
    ): ComicResponse = networkHandler {
        comicApi.getSeriesEpisode(seriesId, episodeId)
    }

    override suspend fun likeShorts(shortsId: Long): Boolean = networkHandler {
        comicApi.likeShorts(shortsId)
    }

    override suspend fun likeSeries(seriesId: Long): Boolean = networkHandler {
        comicApi.likeSeries(seriesId)
    }

    override suspend fun <T> getComicView(): List<ComicViewResponse<T>> = networkHandler {
        comicApi.getComicView()
    }
}

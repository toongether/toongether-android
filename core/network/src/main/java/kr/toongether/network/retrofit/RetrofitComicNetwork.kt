package kr.toongether.network.retrofit

import kr.toongether.common.network.networkHandler
import kr.toongether.network.datasource.CommentNetworkDataSource
import kr.toongether.network.datasource.HomeNetworkDataSource
import kr.toongether.network.datasource.LikeNetworkDataSource
import kr.toongether.network.datasource.SeriesNetworkDataSource
import kr.toongether.network.datasource.ShortsNetworkDataSource
import kr.toongether.network.model.CommentListResponse
import kr.toongether.network.model.EpisodeResponse
import kr.toongether.network.model.HomeViewResponse
import kr.toongether.network.model.SeriesEpisodeListResponse
import kr.toongether.network.model.SeriesListResponse
import kr.toongether.network.model.ShortsListResponse
import kr.toongether.network.model.ShortsResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitComicNetworkApi {
    @GET("comic/shorts/{shortsId}")
    suspend fun getShorts(
        @Path("shortsId") shortsId: Long,
    ): ShortsResponse

    @GET("comic/shorts/my")
    suspend fun getMyShortsList(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): ShortsListResponse

    @GET("comic/shorts/list")
    suspend fun getShortsList(
        @Query("sortBy") sortBy: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): ShortsListResponse

    @GET("comic/series/my")
    suspend fun getMySeries(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): SeriesListResponse

    @GET("comic/series/list")
    suspend fun getSeriesList(
        @Query("dayOfWeek") dayOfWeek: String,
        @Query("cycle") cycle: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): SeriesListResponse

    @GET("comic/series/episode/{seriesId}")
    suspend fun getSeriesEpisodeList(
        @Path("seriesId") seriesId: Long,
    ): SeriesEpisodeListResponse

    @GET("comic/series/episode/{seriesId}/{episodeNumber}")
    suspend fun getSeriesEpisode(
        @Path("seriesId") seriesId: Long,
        @Path("episodeNumber") episodeNumber: Long,
    ): EpisodeResponse

    @GET("comic/series/episode/my/{seriesId}")
    suspend fun getMySeriesEpisodeList(
        @Path("seriesId") seriesId: Long,
    ): SeriesEpisodeListResponse

    @POST("like/shorts/{shortsId}")
    suspend fun likeShorts(
        @Path("shortsId") shortsId: Long,
    ): Boolean

    @POST("like/series/{seriesEpisodeId}")
    suspend fun likeSeries(
        @Path("seriesEpisodeId") seriesEpisodeId: Long,
    ): Boolean

    @GET("comment/{episodeId}")
    suspend fun getComments(
        @Path("episodeId") episodeId: Long,
        @Query("page") page: Int,
    ): CommentListResponse

    @GET("home/get/comic")
    suspend fun getHomeView(): List<HomeViewResponse<Any>>
}

@Singleton
internal class RetrofitComicNetwork @Inject constructor(
    retrofit: Retrofit
) : ShortsNetworkDataSource, HomeNetworkDataSource, LikeNetworkDataSource, SeriesNetworkDataSource,
    CommentNetworkDataSource {
    private val comicApi = retrofit.create(RetrofitComicNetworkApi::class.java)
    override suspend fun getComments(episodeId: Long, page: Int): CommentListResponse =
        networkHandler {
            comicApi.getComments(episodeId, page)
        }

    override suspend fun getHomeView(): List<HomeViewResponse<Any>> = networkHandler {
        comicApi.getHomeView()
    }

    override suspend fun likeShorts(shortsId: Long): Boolean = networkHandler {
        comicApi.likeShorts(shortsId)
    }

    override suspend fun likeSeries(seriesEpisodeId: Long): Boolean = networkHandler {
        comicApi.likeSeries(seriesEpisodeId)
    }

    override suspend fun getMySeries(page: Int, limit: Int): SeriesListResponse = networkHandler {
        comicApi.getMySeries(page, limit)
    }

    override suspend fun getSeriesList(
        dayOfWeek: String,
        cycle: String,
        page: Int,
        limit: Int
    ): SeriesListResponse = networkHandler {
        comicApi.getSeriesList(dayOfWeek, cycle, page, limit)
    }

    override suspend fun getSeriesEpisodeList(seriesId: Long): SeriesEpisodeListResponse =
        networkHandler {
            comicApi.getSeriesEpisodeList(seriesId)
        }

    override suspend fun getSeriesEpisode(seriesId: Long, episodeNumber: Long): EpisodeResponse =
        networkHandler {
            comicApi.getSeriesEpisode(seriesId, episodeNumber)
        }

    override suspend fun getMySeriesEpisodeList(seriesId: Long): SeriesEpisodeListResponse =
        networkHandler {
            comicApi.getMySeriesEpisodeList(seriesId)
        }

    override suspend fun getShorts(shortsId: Long): ShortsResponse = networkHandler {
        comicApi.getShorts(shortsId)
    }

    override suspend fun getMyShortsList(page: Int, limit: Int): ShortsListResponse = networkHandler {
        comicApi.getMyShortsList(page, limit)
    }

    override suspend fun getShortsList(sortBy: String, page: Int, limit: Int): ShortsListResponse = networkHandler {
        comicApi.getShortsList(sortBy, page, limit)
    }
}

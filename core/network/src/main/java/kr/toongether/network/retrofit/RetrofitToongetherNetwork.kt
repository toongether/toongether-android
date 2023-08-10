package kr.toongether.network.retrofit

import kr.toongether.network.ToongetherNetworkDataSource
import kr.toongether.network.model.ComicListResponse
import kr.toongether.network.model.ShortsResponse
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitToongetherNetworkApi {
    @GET("comic/shorts")
    suspend fun getShortsList(): List<ShortsResponse>

    @GET("comic/shorts/list/{id}")
    suspend fun getComicList(
        @Path("id") id: Long
    ): ComicListResponse
}

private const val ToongetherUrl = "http://api.toongether.kr:8002/"

@Singleton
class RetrofitToongetherNetwork @Inject constructor(
    gsonConverterFactory: GsonConverterFactory,
    okHttpCallFactory: Call.Factory
) : ToongetherNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(ToongetherUrl)
        .callFactory(okHttpCallFactory)
        .addConverterFactory(gsonConverterFactory)
        .build()
        .create(RetrofitToongetherNetworkApi::class.java)

    override suspend fun getShortsList(): List<ShortsResponse> =
        networkApi.getShortsList()

    override suspend fun getComicList(id: Long): ComicListResponse =
        networkApi.getComicList(id)
}

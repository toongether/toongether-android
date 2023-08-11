package kr.toongether.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kr.toongether.network.ToongetherNetworkDataSource
import kr.toongether.network.model.ComicListResponse
import kr.toongether.network.model.ShortsResponse
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
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
    networkJson: Json,
    okHttpCallFactory: Call.Factory
) : ToongetherNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(ToongetherUrl)
        .callFactory(okHttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(RetrofitToongetherNetworkApi::class.java)

    override suspend fun getShortsList(): List<ShortsResponse> =
        networkApi.getShortsList()

    override suspend fun getComicList(id: Long): ComicListResponse =
        networkApi.getComicList(id)
}

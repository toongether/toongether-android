package kr.toongether.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kr.toongether.network.ToongetherAuthNetworkDataSource
import kr.toongether.network.ToongetherNetworkDataSource
import kr.toongether.network.model.ComicListResponse
import kr.toongether.network.model.LoginRequest
import kr.toongether.network.model.ShortsResponse
import kr.toongether.network.model.TokenResponse
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
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

private interface RetrofitToongetherAuthNetworkApi {
    @POST("user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): TokenResponse
}

private const val ToongetherUrl = "http://api.toongether.kr:8002/"
private const val ToongetherAuthUrl = "http://api.toongether.kr:8001/"

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

@Singleton
class RetrofitToongetherAuthNetwork @Inject constructor(
    networkJson: Json,
    okHttpCallFactory: Call.Factory
) : ToongetherAuthNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(ToongetherAuthUrl)
        .callFactory(okHttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(RetrofitToongetherAuthNetworkApi::class.java)

    override suspend fun login(loginRequest: LoginRequest): TokenResponse =
        networkApi.login(loginRequest)
}

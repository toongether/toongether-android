package kr.toongether.network.retrofit

import kr.toongether.network.ToongetherNetworkDataSource
import kr.toongether.network.model.ShortsResponse
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitToongetherNetworkApi {
    @GET("comic/shorts")
    suspend fun getShortsList(
    ): List<ShortsResponse>
}

private const val ToongetherUrl = "http://api.toongether.kr:8002/"

@Singleton
class RetrofitToongetherNetwork @Inject constructor(
    gsonConverterFactory: GsonConverterFactory,
    okHttpCallFactory: Call.Factory,
) : ToongetherNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(ToongetherUrl)
        .callFactory(okHttpCallFactory)
        .addConverterFactory(gsonConverterFactory)
        .build()
        .create(RetrofitToongetherNetworkApi::class.java)

    override suspend fun getShortsList(): List<ShortsResponse> =
        networkApi.getShortsList()

}
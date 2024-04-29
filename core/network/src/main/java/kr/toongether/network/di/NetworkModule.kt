package kr.toongether.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import kr.toongether.network.datasource.CommentNetworkDataSource
import kr.toongether.network.datasource.EmailNetworkDataSource
import kr.toongether.network.datasource.HomeNetworkDataSource
import kr.toongether.network.datasource.LikeNetworkDataSource
import kr.toongether.network.datasource.SeriesNetworkDataSource
import kr.toongether.network.datasource.ShortsNetworkDataSource
import kr.toongether.network.datasource.UserNetworkDataSource
import kr.toongether.network.interceptor.AuthInterceptor
import kr.toongether.network.retrofit.RetrofitComicNetwork
import kr.toongether.network.retrofit.RetrofitUserNetwork
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

private const val ToongetherUrl = "https://test.toongether.kr:8080/"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providesOkHttpCallFactory(
        authInterceptor: AuthInterceptor
    ): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .addInterceptor(authInterceptor)
        .build()

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun providesRetrofitToongetherNetwork(
        networkJson: Json,
        okHttpCallFactory: Call.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(ToongetherUrl)
        .callFactory(okHttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
}

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {
    @Singleton
    @Binds
    fun bindsShortsNetworkDataSource(
        retrofitComicNetwork: RetrofitComicNetwork
    ): ShortsNetworkDataSource

    @Singleton
    @Binds
    fun bindsSeriesNetworkDataSource(
        retrofitComicNetwork: RetrofitComicNetwork
    ): SeriesNetworkDataSource

    @Singleton
    @Binds
    fun bindsCommentNetworkDataSource(
        retrofitComicNetwork: RetrofitComicNetwork
    ): CommentNetworkDataSource

    @Singleton
    @Binds
    fun bindsHomeNetworkDataSource(
        retrofitComicNetwork: RetrofitComicNetwork
    ): HomeNetworkDataSource

    @Singleton
    @Binds
    fun bindsLikeNetworkDataSource(
        retrofitComicNetwork: RetrofitComicNetwork
    ): LikeNetworkDataSource

    @Singleton
    @Binds
    fun bindsUserNetworkDataSource(
        retrofitUserNetwork: RetrofitUserNetwork
    ): UserNetworkDataSource

    @Singleton
    @Binds
    fun bindsEmailNetworkDataSource(
        retrofitUserNetwork: RetrofitUserNetwork
    ): EmailNetworkDataSource
}

package kr.toongether.network.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.toongether.network.ToongetherNetworkDataSource
import kr.toongether.network.retrofit.RetrofitToongetherNetwork
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providesOkHttpCallFactory(): Call.Factory = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    @Singleton
    @Provides
    fun providesGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()
}

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Singleton
    @Binds
    fun bindsToongetherNetworkDataSource(
        retrofitToongetherNetwork: RetrofitToongetherNetwork
    ): ToongetherNetworkDataSource
}

package kr.toongether.network.interceptor

import dagger.Lazy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kr.hs.dgsw.smartschool.datastore.ToongetherPreferencesDataSource
import kr.toongether.network.datasource.UserNetworkDataSource
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val toongetherPreferences: ToongetherPreferencesDataSource,
    private val userNetworkDataSource: Lazy<UserNetworkDataSource>
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token: String = runBlocking {
            toongetherPreferences.accessToken.first()
        }

        val request = chain.request().newBuilder()
            .apply { if (token.isNotBlank()) addHeader(AUTHORIZATION, "Bearer $token") }
            .build()

        var response = chain.proceed(request)

        if (response.code == 401) {
            response.close()

            runBlocking(Dispatchers.IO) {
                kotlin.runCatching {
                    userNetworkDataSource.get()
                        .refreshToken(RefreshTokenRequest(toongetherPreferences.refreshToken.first()))
                }.onSuccess {
                    toongetherPreferences.saveAccessToken(it.content)

                    val newRequest = chain.request().newBuilder()
                        .addHeader(AUTHORIZATION, "Bearer ${it.content}")
                        .build()

                    response = chain.proceed(newRequest)

                    if (response.code == 401) {
                        response.close()

                        runBlocking(Dispatchers.IO) {
                            kotlin.runCatching {
                                userNetworkDataSource.get().login(
                                    LoginRequest(
                                        userId = toongetherPreferences.id.first(),
                                        password = toongetherPreferences.pw.first()
                                    )
                                )
                            }.onSuccess { token ->
                                toongetherPreferences.saveAccessToken(token.accessToken)
                                toongetherPreferences.saveRefreshToken(token.refreshToken)

                                val secondRequest = chain.request().newBuilder()
                                    .addHeader(AUTHORIZATION, "Bearer ${it.content}")
                                    .build()

                                response = chain.proceed(secondRequest)
                            }
                        }
                    }
                }
            }
        }

        return response
    }

    companion object {
        const val AUTHORIZATION = "Authorization"
    }
}

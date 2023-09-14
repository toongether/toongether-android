package kr.toongether.network.interceptor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kr.hs.dgsw.smartschool.datastore.ToongetherPreferencesDataSource
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.net.HttpURLConnection.HTTP_OK
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    private val toongetherPreferences: ToongetherPreferencesDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token: String = runBlocking {
            toongetherPreferences.accessToken.first()
        }

        if (token.isBlank()) {
            errorResponse(chain.request())
        }

        val request = chain.request().newBuilder()
            .apply { if (token.isNotBlank()) header(AUTHORIZATION, "Bearer $token") }
            .build()

        val response = chain.proceed(request)

        if (response.code == HTTP_OK) {
            val newAccessToken: String = response.header(AUTHORIZATION, null) ?: return response

            CoroutineScope(Dispatchers.IO).launch {
                val existedAccessToken = toongetherPreferences.accessToken.first()
                if (existedAccessToken != newAccessToken) {
                    toongetherPreferences.saveAccessToken(newAccessToken)
                }
            }
        }

        return response
    }

    private fun errorResponse(request: Request): Response = Response.Builder()
        .request(request)
        .protocol(Protocol.HTTP_2)
        .code(NETWORK_ERROR)
        .message("")
        .body("".toResponseBody(null))
        .build()

    companion object {
        const val AUTHORIZATION = "Authorization"
        const val NETWORK_ERROR = 401
    }
}

package kr.toongether.network.interceptor

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kr.hs.dgsw.smartschool.datastore.ToongetherPreferencesDataSource
import kr.toongether.network.interceptor.AuthInterceptor.Companion.AUTHORIZATION
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthAuthenticator @Inject constructor(
    private val toongetherPreferences: ToongetherPreferencesDataSource
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val refreshToken = runBlocking {
            toongetherPreferences.refreshToken.first()
        }

        if (refreshToken.isBlank()) {
            response.close()
            return null
        }

        return newRequestWithToken(refreshToken, response.request)
    }

    private fun newRequestWithToken(token: String, request: Request): Request =
        request.newBuilder()
            .header(AUTHORIZATION, token)
            .build()
}

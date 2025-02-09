package kr.toongether.network.retrofit

import kotlinx.serialization.json.JsonPrimitive
import kr.toongether.common.network.networkHandler
import kr.toongether.network.datasource.UserNetworkDataSource
import kr.toongether.network.model.EmailRequest
import kr.toongether.network.model.LoginRequest
import kr.toongether.network.model.RefreshTokenRequest
import kr.toongether.network.model.SignupRequest
import kr.toongether.network.model.TokenResponse
import kr.toongether.network.model.UserResponse
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitUserNetworkApi {
    @POST("user/signup")
    suspend fun signup(
        @Body signupRequest: SignupRequest
    )

    @POST("user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): TokenResponse

    @POST("email/send")
    suspend fun sendEmail(
        @Body emailRequest: EmailRequest
    )

    @GET("email/check")
    suspend fun checkEmail(
        @Query("email") email: String,
        @Query("code") code: String
    ): Boolean

    @GET("user/info")
    suspend fun getUser(): UserResponse

    @DELETE("user/delete")
    suspend fun deleteUser()

    @POST("user/refresh")
    suspend fun refreshToken(
        @Body refreshTokenRequest: RefreshTokenRequest
    ): JsonPrimitive

    @GET("user/validate")
    suspend fun checkDuplicateUser(
        @Query("userId") userId: String
    ): Boolean

    @GET("email/validate")
    suspend fun checkDuplicateEmail(
        @Query("email") email: String
    ): Boolean
}

@Singleton
internal class RetrofitUserNetwork @Inject constructor(
    retrofit: Retrofit
) : UserNetworkDataSource {
    private val userApi = retrofit.create(RetrofitUserNetworkApi::class.java)

    override suspend fun signup(signupRequest: SignupRequest) = networkHandler {
        userApi.signup(signupRequest)
    }

    override suspend fun login(loginRequest: LoginRequest): TokenResponse = networkHandler {
        userApi.login(loginRequest)
    }

    override suspend fun sendEmail(emailRequest: EmailRequest) = networkHandler {
        userApi.sendEmail(emailRequest)
    }

    override suspend fun checkEmail(email: String, code: String): Boolean = networkHandler {
        userApi.checkEmail(email, code)
    }

    override suspend fun getUser(): UserResponse = networkHandler {
        userApi.getUser()
    }

    override suspend fun deleteUser() = networkHandler {
        userApi.deleteUser()
    }

    override suspend fun refreshToken(
        refreshTokenRequest: RefreshTokenRequest
    ): JsonPrimitive = networkHandler {
        userApi.refreshToken(refreshTokenRequest)
    }

    override suspend fun checkDuplicateUser(userId: String): Boolean = networkHandler {
        userApi.checkDuplicateUser(userId)
    }

    override suspend fun checkDuplicateEmail(email: String): Boolean = networkHandler {
        userApi.checkDuplicateEmail(email)
    }
}

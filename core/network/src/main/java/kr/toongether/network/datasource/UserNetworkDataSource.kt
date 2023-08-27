package kr.toongether.network.datasource

import kr.toongether.network.model.EmailRequest
import kr.toongether.network.model.LoginRequest
import kr.toongether.network.model.SignupRequest
import kr.toongether.network.model.TokenResponse
import kr.toongether.network.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UserNetworkDataSource {
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
        @Query("code") code: String,
    ): Boolean

    @GET("user/info/{id}")
    suspend fun getUser(
        @Path("id") id: Long,
    ): UserResponse
}

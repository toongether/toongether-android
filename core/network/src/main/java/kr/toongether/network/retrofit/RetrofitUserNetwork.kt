package kr.toongether.network.retrofit

import kotlinx.serialization.json.JsonPrimitive
import kr.toongether.common.network.networkHandler
import kr.toongether.network.datasource.EmailNetworkDataSource
import kr.toongether.network.datasource.UserNetworkDataSource
import kr.toongether.network.model.ChangePasswordRequest
import kr.toongether.network.model.EmailAuthRequest
import kr.toongether.network.model.LoginRequest
import kr.toongether.network.model.LoginTokenResponse
import kr.toongether.network.model.RefreshAccessTokenRequest
import kr.toongether.network.model.SignupRequest
import kr.toongether.network.model.UserInfoResponse
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitUserNetworkApi {
    @POST("user/signup")
    suspend fun signup(
        @Body signupRequest: SignupRequest
    )

    @POST("user/refresh")
    suspend fun refreshToken(
        @Body refreshAccessTokenRequest: RefreshAccessTokenRequest
    ): JsonPrimitive

    @POST("user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginTokenResponse

    @PATCH("user/change/password")
    suspend fun changePassword(
        @Body changePasswordRequest: ChangePasswordRequest
    )

    @GET("user/validate")
    suspend fun validateUser(
        userId: String
    ): Boolean

    @GET("user/info")
    suspend fun getUserInfo(): UserInfoResponse

    @DELETE("user/delete")
    suspend fun deleteUser()

    @POST("email/send")
    suspend fun sendEmail(emailAuthRequest: EmailAuthRequest)

    @GET("email/validate")
    suspend fun validateEmail(email: String): Boolean

    @GET("email/check")
    suspend fun checkEmail(email: String, code: String): Boolean
}

@Singleton
internal class RetrofitUserNetwork @Inject constructor(
    retrofit: Retrofit
) : UserNetworkDataSource, EmailNetworkDataSource {
    private val userApi = retrofit.create(RetrofitUserNetworkApi::class.java)
    override suspend fun sendEmail(email: String) = networkHandler {
        userApi.sendEmail(EmailAuthRequest(email))
    }

    override suspend fun validateEmail(email: String): Boolean = networkHandler {
        userApi.validateEmail(email)
    }

    override suspend fun checkEmail(email: String, code: String): Boolean = networkHandler {
        userApi.checkEmail(email, code)
    }

    override suspend fun signup(
        userId: String,
        password: String,
        name: String,
        email: String,
        code: String
    ) = networkHandler {
        userApi.signup(SignupRequest(userId, password, name, email, code))
    }

    override suspend fun refreshToken(refreshToken: String): JsonPrimitive = networkHandler {
        userApi.refreshToken(RefreshAccessTokenRequest(refreshToken))
    }

    override suspend fun login(userId: String, password: String): LoginTokenResponse =
        networkHandler {
            userApi.login(LoginRequest(userId, password))
        }

    override suspend fun changePassword(
        existingPassword: String,
        changePassword: String,
        checkChangePassword: String
    ) = networkHandler {
        userApi.changePassword(
            ChangePasswordRequest(
                existingPassword,
                changePassword,
                checkChangePassword
            )
        )
    }

    override suspend fun validateUser(userId: String): Boolean = networkHandler {
        userApi.validateUser(userId)
    }

    override suspend fun getUserInfo(): UserInfoResponse = networkHandler {
        userApi.getUserInfo()
    }

    override suspend fun deleteUser() = networkHandler {
        userApi.deleteUser()
    }

}

package kr.toongether.network.datasource

import kotlinx.serialization.json.JsonPrimitive
import kr.toongether.network.model.LoginTokenResponse
import kr.toongether.network.model.UserInfoResponse

interface UserNetworkDataSource {
    suspend fun signup(
        userId: String,
        password: String,
        name: String,
        email: String,
        code: String,
    )
    suspend fun refreshToken(refreshToken: String): JsonPrimitive
    suspend fun login(userId: String, password: String): LoginTokenResponse
    suspend fun changePassword(
        existingPassword: String,
        changePassword: String,
        checkChangePassword: String,
    )
    suspend fun validateUser(userId: String): Boolean
    suspend fun getUserInfo(): UserInfoResponse
    suspend fun deleteUser()
}

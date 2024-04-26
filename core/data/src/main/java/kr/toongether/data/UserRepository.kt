package kr.toongether.data

import kotlinx.coroutines.flow.Flow
import kr.toongether.model.LoginToken
import kr.toongether.model.UserInfo

interface UserRepository {
    suspend fun signup(
        userId: String,
        password: String,
        name: String,
        email: String,
        code: String,
    )
    fun refreshToken(refreshToken: String): Flow<String>
    fun login(userId: String, password: String): Flow<LoginToken>
    suspend fun changePassword(
        existingPassword: String,
        changePassword: String,
        checkChangePassword: String,
    )
    fun validateUser(userId: String): Flow<Boolean>
    fun getUserInfo(): Flow<UserInfo>
    suspend fun deleteUser()
}

package kr.toongether.data

import kotlinx.coroutines.flow.Flow

interface EmailRepository {
    suspend fun sendEmail(email: String)
    fun validateEmail(email: String): Flow<Boolean>
    fun checkEmail(email: String, code: String): Flow<Boolean>
}

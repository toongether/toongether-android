package kr.toongether.network.datasource

interface EmailNetworkDataSource {
    suspend fun sendEmail(email: String)
    suspend fun validateEmail(email: String): Boolean
    suspend fun checkEmail(email: String, code: String): Boolean
}
package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignupRequest(
    @SerialName("userId")
    val userId: String,
    @SerialName("password")
    val password: String,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("code")
    val code: String
)

package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmailAuthRequest(
    @SerialName("email") val email: String,
)

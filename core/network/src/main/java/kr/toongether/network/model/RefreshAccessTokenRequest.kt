package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshAccessTokenRequest(
    @SerialName("refreshToken") val refreshToken: String,
)

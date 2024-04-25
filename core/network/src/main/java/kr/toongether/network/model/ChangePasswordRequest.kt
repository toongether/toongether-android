package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChangePasswordRequest(
    @SerialName("existingPassword") val existingPassword: String,
    @SerialName("changePassword") val changePassword: String,
    @SerialName("checkChangePassword") val checkChangePassword: String,
)

package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkAuthor(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("profileImage") val profileImage: String?,
)

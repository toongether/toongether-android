package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortsListResponse(
    @SerialName("shortsResponse") val shortsResponse: List<ShortsResponse>,
    @SerialName("hasMorePage") val hasMorePage: Boolean,
    @SerialName("currentPage") val currentPage: Int,
)

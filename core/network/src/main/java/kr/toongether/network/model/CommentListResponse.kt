package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommentListResponse(
    @SerialName("commentResponses") val commentResponse: List<CommentResponse>,
    @SerialName("hasMorePage") val hasMorePage: Boolean,
    @SerialName("currentPage") val currentPage: Int,
)

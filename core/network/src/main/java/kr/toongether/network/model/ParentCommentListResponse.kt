package kr.toongether.network.model

import kotlinx.serialization.SerialName

data class ParentCommentListResponse(
    @SerialName("parentCommentResponses") val parentCommentResponses: List<ParentCommentResponse>,
    @SerialName("hasMorePage") val hasMorePage: Boolean,
    @SerialName("currentPage") val currentPage: Int,
)

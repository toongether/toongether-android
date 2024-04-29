package kr.toongether.network.model

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommentResponse(
    @SerialName("id") val id: Long,
    @SerialName("body") val body: String,
    @SerialName("author") val author: String,
    @SerialName("userId") val userId: Long,
    @SerialName("createdDate") val createdDate: Instant,
    @SerialName("parentCommentResponses") val parentCommentResponses: List<ParentCommentResponse>
)

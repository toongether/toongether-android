package kr.toongether.data.model

import kotlinx.datetime.LocalDateTime
import kr.toongether.model.Comment
import kr.toongether.network.model.CommentResponse

internal fun CommentResponse.asModel() = Comment(
    id = id,
    body = body,
    author = author,
    userId = userId,
    createdDate = createdDate,
)
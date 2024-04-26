package kr.toongether.data.model

import kr.toongether.model.ParentComment
import kr.toongether.network.model.ParentCommentResponse

internal fun ParentCommentResponse.asModel() = ParentComment(
    body = body,
    author = author,
    userId = userId,
    createdDate = createdDate,
)

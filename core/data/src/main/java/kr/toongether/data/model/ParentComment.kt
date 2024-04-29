package kr.toongether.data.model

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kr.toongether.model.ParentComment
import kr.toongether.network.model.ParentCommentResponse

internal fun ParentCommentResponse.asModel() = ParentComment(
    body = body,
    author = author,
    userId = userId,
    createdDate = createdDate.toLocalDateTime(TimeZone.currentSystemDefault()),
)

package kr.toongether.data.model

import kr.toongether.model.ParentCommentList
import kr.toongether.network.model.ParentCommentListResponse

internal fun ParentCommentListResponse.asModel() = ParentCommentList(
    parentComments = parentCommentResponses.map { it.asModel() },
    hasMorePage = hasMorePage,
    currentPage = currentPage,
)
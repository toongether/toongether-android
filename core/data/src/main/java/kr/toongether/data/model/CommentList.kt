package kr.toongether.data.model

import kr.toongether.model.CommentList
import kr.toongether.network.model.CommentListResponse

internal fun CommentListResponse.asModel() = CommentList(
    comments = commentResponse.map { it.asModel() },
    hasMorePage = hasMorePage,
    currentPage = currentPage,
)

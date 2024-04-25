package kr.toongether.model

data class ParentCommentList(
    val parentCommentResponses: List<ParentComment>,
    val hasMorePage: Boolean,
    val currentPage: Int,
)

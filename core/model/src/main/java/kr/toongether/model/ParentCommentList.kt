package kr.toongether.model

data class ParentCommentList(
    val parentComments: List<ParentComment>,
    val hasMorePage: Boolean,
    val currentPage: Int,
)

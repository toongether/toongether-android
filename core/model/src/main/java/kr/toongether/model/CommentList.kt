package kr.toongether.model

data class CommentList(
    val comments: List<Comment>,
    val hasMorePage: Boolean,
    val currentPage: Int,
)

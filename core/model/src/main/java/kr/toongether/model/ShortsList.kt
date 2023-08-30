package kr.toongether.model

data class ShortsList(
    val shortsList: List<Shorts>,
    val hasMorePage: Boolean,
    val currentPage: Int,
)

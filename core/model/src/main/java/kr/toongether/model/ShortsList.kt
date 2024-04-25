package kr.toongether.model

data class ShortsList(
    val shorts: List<Shorts>,
    val hasMorePage: Boolean,
    val currentPage: Int,
)

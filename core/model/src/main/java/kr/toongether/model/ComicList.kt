package kr.toongether.model

data class ComicList(
    val imageUrl: List<String>,
    val width: Int,
    val height: Int,
    val lastHeight: Int,
    val endIndex: Int,
)

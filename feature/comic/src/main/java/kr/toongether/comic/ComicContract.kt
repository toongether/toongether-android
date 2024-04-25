package kr.toongether.comic

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class ComicState(
    val comic: Comic = Comic(
        id = 0L,
        title = "",
        thumbnail = "",
        imageUrl = emptyList(),
        createdDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
        width = 0,
        height = 0,
        lastHeight = 0,
        endIndex = 0,
        beforeEpisode = 0L,
        nextEpisode = 0L,
        likeCount = 0,
        commentCount = 0,
        liked = false
    ),
    val error: Throwable? = null,
    val likeCount: Int = comic.likeCount,
    val liked: Boolean = comic.liked,
    val isLoading: Boolean = false
)

sealed class ComicSideEffect {
    data class Toast(val text: String) : ComicSideEffect()
    object LoginToast : ComicSideEffect()
}

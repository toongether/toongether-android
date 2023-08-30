package kr.toongether.comic

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kr.toongether.model.Comic

data class ComicState(
    val comic: Comic = Comic(
        title = "",
        thumbnail = "",
        imageUrl = emptyList(),
        createdDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()),
        width = 0,
        height = 0,
        lastHeight = 0,
        endIndex = 0
    ),
    val error: Throwable? = null,
    val isLoading: Boolean = false
)

sealed class ComicSideEffect {
    data class Toast(val text: String) : ComicSideEffect()
}

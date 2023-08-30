package kr.toongether.shorts

import androidx.paging.PagingData
import kr.toongether.model.Shorts
import kr.toongether.model.ShortsList

data class ShortsState(
    val shortsList: ShortsList = ShortsList(emptyList(), false, 1),
    val isLoading: Boolean = false
)

sealed class ShortsSideEffect {
    data class Toast(val text: String) : ShortsSideEffect()
}

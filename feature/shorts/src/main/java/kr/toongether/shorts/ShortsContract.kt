package kr.toongether.shorts

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.model.Shorts

data class ShortsState(
    val shortsList: Flow<PagingData<Shorts>>,
    val isLoading: Boolean = false
)

sealed class ShortsSideEffect {
    data class Toast(val text: String) : ShortsSideEffect()
}

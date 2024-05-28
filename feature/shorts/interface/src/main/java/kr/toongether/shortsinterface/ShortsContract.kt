package kr.toongether.shortsinterface

import kr.toongether.model.Shorts
import kr.toongether.model.ShortsDetail

sealed interface ShortsUiState {
    data object Loading : ShortsUiState
    data class Success(
        val shortsList: List<Shorts>,
        val shorts: List<ShortsDetail>
    ) : ShortsUiState
    data class Error(val message: String) : ShortsUiState
}

sealed class ShortsSideEffect {
    data class Toast(val text: String) : ShortsSideEffect()
}

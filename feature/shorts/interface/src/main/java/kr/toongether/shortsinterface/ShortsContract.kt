package kr.toongether.shortsinterface

sealed interface ShortsUiState {
    data object Loading : ShortsUiState
    data class Success(val data: ) : ShortsUiState
    data class Error(val message: String) : ShortsUiState
}

sealed class ShortsSideEffect {
    data class Toast(val text: String) : ShortsSideEffect()
}

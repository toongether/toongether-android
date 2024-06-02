package kr.toongether.comicinterface

import kr.toongether.model.EpisodeDetail
import kr.toongether.model.ShortsDetail

sealed interface ComicUiState {
    data object Loading : ComicUiState
    data class Success(val episode: EpisodeDetail) : ComicUiState
    data class Error(val message: String) : ComicUiState
}

sealed interface ComicSideEffect {
    data object NavigateToLogin : ComicSideEffect
}

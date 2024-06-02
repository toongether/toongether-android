package kr.toongether.episodeinterface

import kr.toongether.model.SeriesEpisodeList

sealed interface EpisodeUiState {
    data class Success(val data: SeriesEpisodeList) : EpisodeUiState
    data object Loading : EpisodeUiState
    data class Error(val message: String) : EpisodeUiState
}

sealed class EpisodeSideEffect {
    data class Toast(val text: String) : EpisodeSideEffect()
}

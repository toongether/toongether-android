package kr.toongether.episodeinterface

import kr.toongether.model.SeriesEpisodeList

sealed interface EpisodeState {
    data class Success(val data: SeriesEpisodeList) : EpisodeState
    object Loading : EpisodeState
}

sealed class EpisodeSideEffect {
    data class Toast(val text: String) : EpisodeSideEffect()
}

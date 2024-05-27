package kr.toongether.seriesinterface

import kr.toongether.model.Series

sealed interface SeriesUiState {
    data object Loading : SeriesUiState
    data class Success(val seriesList: List<List<Series>>) : SeriesUiState
    data class Error(val message: String) : SeriesUiState
}

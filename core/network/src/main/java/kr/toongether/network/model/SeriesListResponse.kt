package kr.toongether.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeriesListResponse(
    @SerialName("seriesResponse")
    val seriesResponse: List<SeriesResponse>,
    @SerialName("hasMorePage")
    val hasMorePage: Boolean,
    @SerialName("currentPage")
    val currentPage: Int
)

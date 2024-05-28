package kr.toongether.network.datasource

import kr.toongether.model.ShortsList
import kr.toongether.network.model.ShortsDetailResponse
import kr.toongether.network.model.ShortsListResponse
import kr.toongether.network.model.ShortsResponse

interface ShortsNetworkDataSource {
    suspend fun getShorts(
        shortsId: Long,
    ): ShortsDetailResponse

    suspend fun getMyShortsList(
        page: Int,
        limit: Int,
    ): ShortsListResponse

    suspend fun getShortsList(
        sortBy: String,
        page: Int,
        limit: Int,
    ): ShortsListResponse
}

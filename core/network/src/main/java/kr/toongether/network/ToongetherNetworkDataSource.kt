package kr.toongether.network

import kr.toongether.network.model.ShortsResponse

interface ToongetherNetworkDataSource {
    suspend fun getShortsList(): List<ShortsResponse>
}

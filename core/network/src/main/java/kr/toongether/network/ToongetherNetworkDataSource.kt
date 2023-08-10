package kr.toongether.network

import kr.toongether.network.model.ComicListResponse
import kr.toongether.network.model.ShortsResponse

interface ToongetherNetworkDataSource {
    suspend fun getShortsList(): List<ShortsResponse>
    suspend fun getComicList(id: Long): ComicListResponse
}

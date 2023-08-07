package kr.toongether.network

import kr.toongether.network.model.WebtoonResponse

interface ToongetherNetworkDataSource {
    suspend fun getWebtoonList(): List<WebtoonResponse>
}
package kr.toongether.network.datasource

import kr.toongether.network.model.HomeViewResponse

interface HomeNetworkDataSource {
    suspend fun getHomeView(): List<HomeViewResponse>
}
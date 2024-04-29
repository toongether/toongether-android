package kr.toongether.data

import kotlinx.coroutines.flow.Flow
import kr.toongether.model.HomeView

interface HomeRepository {
    fun getHomeView(): Flow<List<HomeView>>
}
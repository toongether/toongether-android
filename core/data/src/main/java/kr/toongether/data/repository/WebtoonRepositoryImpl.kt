package kr.toongether.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.toongether.data.model.asModel
import kr.toongether.model.Webtoon
import kr.toongether.network.ToongetherNetworkDataSource
import javax.inject.Inject

class WebtoonRepositoryImpl @Inject constructor(
    private val network: ToongetherNetworkDataSource
) : WebtoonRepository {
    override fun getWebtoonList(): Flow<List<Webtoon>> = flow {
        network.getWebtoonList().map { it.asModel() }
    }
}
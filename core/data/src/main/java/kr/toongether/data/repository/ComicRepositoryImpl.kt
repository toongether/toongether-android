package kr.toongether.data.repository

import kr.toongether.data.model.asModel
import kr.toongether.model.Shorts
import kr.toongether.network.ToongetherNetworkDataSource
import javax.inject.Inject

class ComicRepositoryImpl @Inject constructor(
    private val network: ToongetherNetworkDataSource
) : ComicRepository {
    override suspend fun getShortsList(): List<Shorts> =
        network.getShortsList().map { it.asModel() }
}
package kr.toongether.data.repository

import kr.toongether.data.ComicRepository
import kr.toongether.data.model.asModel
import kr.toongether.model.Comic
import kr.toongether.model.Series
import kr.toongether.model.SeriesList
import kr.toongether.model.ShortsList
import kr.toongether.network.datasource.ComicNetworkDataSource
import kr.toongether.network.model.NetworkCycle
import kr.toongether.network.model.NetworkDayOfWeek
import javax.inject.Inject

internal class ComicRepositoryImpl @Inject constructor(
    private val network: ComicNetworkDataSource
) : ComicRepository {
    override suspend fun getShortsList(page: Int): List<ShortsList> =
        network.getShortsList(page).map { it.asModel() }

    override suspend fun getShortsEpisode(id: Long): Comic =
        network.getShortsEpisode(id).asModel()

    override suspend fun getSeriesList(
        dayOfWeek: NetworkDayOfWeek,
        cycle: NetworkCycle,
        page: Int
    ): List<SeriesList> =
        network.getSeriesList(
            dayOfWeek = dayOfWeek,
            cycle = cycle,
            page = page,
        ).map { it.asModel() }

    override suspend fun getSeries(id: Long): Series =
        network.getSeries(id).asModel()

    override suspend fun getSeriesEpisode(seriesId: Long, episodeId: Long): Comic =
        network.getSeriesEpisode(seriesId, episodeId).asModel()

}

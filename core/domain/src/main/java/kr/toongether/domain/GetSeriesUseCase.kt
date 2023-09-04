package kr.toongether.domain

import kr.toongether.data.ComicRepository
import kr.toongether.model.SeriesEpisode
import javax.inject.Inject

class GetSeriesUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke(id: Long): Result<SeriesEpisode> = kotlin.runCatching {
        repository.getSeries(id = id)
    }
}

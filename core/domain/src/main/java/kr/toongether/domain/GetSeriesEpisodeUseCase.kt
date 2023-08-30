package kr.toongether.domain

import kr.toongether.data.ComicRepository
import kr.toongether.model.Comic
import javax.inject.Inject

class GetSeriesEpisodeUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke(
        seriesId: Long,
        episodeId: Long
    ): Result<Comic> = kotlin.runCatching {
        repository.getSeriesEpisode(
            seriesId = seriesId,
            episodeId = episodeId
        )
    }
}

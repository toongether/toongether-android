package kr.toongether.domain

import kr.toongether.data.ComicRepository
import javax.inject.Inject

class LikeSeriesUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke(seriesId: Long): Result<Boolean> = kotlin.runCatching {
        repository.likeSeries(seriesId)
    }
}

package kr.toongether.domain

import kr.toongether.data.ComicRepository
import kr.toongether.model.Comic
import javax.inject.Inject

class GetShortsEpisodeUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke(id: Long): Result<Comic> = kotlin.runCatching {
        repository.getShortsEpisode(id = id)
    }
}

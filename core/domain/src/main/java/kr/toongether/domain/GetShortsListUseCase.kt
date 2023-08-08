package kr.toongether.domain

import kr.toongether.data.repository.ComicRepository
import kr.toongether.model.Shorts
import javax.inject.Inject

class GetShortsListUseCase @Inject constructor(
    private val comicRepository: ComicRepository
) {
    suspend operator fun invoke(): Result<List<Shorts>> = kotlin.runCatching {
        comicRepository.getShortsList()
    }
}

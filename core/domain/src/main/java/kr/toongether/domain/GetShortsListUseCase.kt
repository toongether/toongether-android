package kr.toongether.domain

import javax.inject.Inject

class GetShortsListUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke(page: Int): Result<ShortsList> = kotlin.runCatching {
        repository.getShortsList(page = page)
    }
}

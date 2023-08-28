package kr.toongether.domain

import kr.toongether.data.ComicRepository
import kr.toongether.model.ShortsList
import javax.inject.Inject

class GetShortsListUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke(page: Int): Result<List<ShortsList>> = kotlin.runCatching {
        repository.getShortsList(page = page)
    }
}

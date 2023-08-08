package kr.toongether.domain

import kr.toongether.data.repository.ComicRepository
import kr.toongether.model.ComicList
import javax.inject.Inject

class GetComicListUseCase @Inject constructor(
    private val comicRepository: ComicRepository
) {
    suspend operator fun invoke(id: Long): Result<ComicList> = kotlin.runCatching {
        comicRepository.getComicList(id)
    }
}
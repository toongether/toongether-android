package kr.toongether.domain

import kr.toongether.data.ComicRepository
import javax.inject.Inject

class GetComicViewUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke() = kotlin.runCatching {
        repository.getComicView()
    }
}

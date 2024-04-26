package kr.toongether.domain

import javax.inject.Inject

class LikeShortsUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke(shortsId: Long): Result<Boolean> = kotlin.runCatching {
        repository.likeShorts(shortsId)
    }
}

package kr.toongether.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.data.ComicRepository
import kr.toongether.model.Shorts
import kr.toongether.model.ShortsList
import javax.inject.Inject

class GetPagingShortsUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    operator fun invoke(): Flow<PagingData<Shorts>> =
        repository.getPagingShorts()
}
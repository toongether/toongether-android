package kr.toongether.domain

import kr.toongether.data.ComicRepository
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import javax.inject.Inject

class GetPagingSeriesUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    operator fun invoke(cycle: Cycle?, dayOfWeek: DayOfWeek?) =
        repository.getPagingSeries(cycle, dayOfWeek)
}

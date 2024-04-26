package kr.toongether.domain

import javax.inject.Inject

class GetPagingSeriesUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    operator fun invoke(cycle: Cycle?, dayOfWeek: DayOfWeek?) =
        repository.getPagingSeries(cycle, dayOfWeek)
}

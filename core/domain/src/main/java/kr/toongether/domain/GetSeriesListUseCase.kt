package kr.toongether.domain

import kr.toongether.data.ComicRepository
import javax.inject.Inject

class GetSeriesListUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke(
        dayOfWeek: DayOfWeek?,
        cycle: Cycle?,
        page: Int
    ): Result<SeriesList> = kotlin.runCatching {
        repository.getSeriesList(
            dayOfWeek = dayOfWeek,
            cycle = cycle,
            page = page
        )
    }
}

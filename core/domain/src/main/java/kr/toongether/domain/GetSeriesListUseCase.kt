package kr.toongether.domain

import kr.toongether.data.ComicRepository
import kr.toongether.model.Cycle
import kr.toongether.model.DayOfWeek
import kr.toongether.model.SeriesList
import javax.inject.Inject

class GetSeriesListUseCase @Inject constructor(
    private val repository: ComicRepository
) {
    suspend operator fun invoke(
        dayOfWeek: DayOfWeek,
        cycle: Cycle,
        page: Int
    ): Result<List<SeriesList>> = kotlin.runCatching {
        repository.getSeriesList(
            dayOfWeek = dayOfWeek,
            cycle = cycle,
            page = page
        )
    }
}

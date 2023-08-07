package kr.toongether.domain

import kotlinx.coroutines.flow.Flow
import kr.toongether.data.repository.WebtoonRepository
import kr.toongether.model.Webtoon
import javax.inject.Inject

class GetWebtoonListUseCase @Inject constructor(
    private val webtoonRepository: WebtoonRepository
) {
    operator fun invoke(): Flow<List<Webtoon>> =
        webtoonRepository.getWebtoonList()
}
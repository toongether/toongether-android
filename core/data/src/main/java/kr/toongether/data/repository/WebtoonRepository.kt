package kr.toongether.data.repository

import kotlinx.coroutines.flow.Flow
import kr.toongether.model.Webtoon

interface WebtoonRepository {
    fun getWebtoonList(): Flow<List<Webtoon>>
}
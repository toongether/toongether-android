package kr.toongether.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.model.Shorts
import kr.toongether.model.SortBy

interface ShortsRepository {
    fun getShorts(
        shortsId: Long,
    ): Flow<Shorts>

    fun getMyShortsList(
        page: Int,
        limit: Int,
    ): Flow<PagingData<Shorts>>

    fun getShortsList(
        sortBy: SortBy,
        page: Int,
        limit: Int,
    ): Flow<PagingData<Shorts>>
}

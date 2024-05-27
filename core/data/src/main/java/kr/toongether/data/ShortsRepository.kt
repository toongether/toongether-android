package kr.toongether.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.model.EpisodeDetail
import kr.toongether.model.Shorts
import kr.toongether.model.ShortsDetail
import kr.toongether.model.ShortsList
import kr.toongether.model.SortBy

interface ShortsRepository {
    fun getShorts(
        shortsId: Long,
    ): Flow<ShortsDetail>

    fun getMyShortsList(
        page: Int = 1,
        limit: Int = 10,
    ): Flow<PagingData<Shorts>>

    fun getPagingShortsList(
        sortBy: SortBy = SortBy.LATELY,
        page: Int = 1,
        limit: Int = 10,
    ): Flow<PagingData<Shorts>>

    fun getShortsList(
        sortBy: SortBy = SortBy.LATELY,
        page: Int = 1,
        limit: Int = 10,
    ): Flow<ShortsList>
}

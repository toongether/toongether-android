package kr.toongether.data

import kotlinx.coroutines.flow.Flow

interface LikeRepository {
    fun likeShorts(
        shortsId: Long
    ): Flow<Boolean>

    fun likeSeries(
        seriesEpisodeId: Long,
    ): Flow<Boolean>
}

package kr.toongether.data

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.toongether.model.Comment

interface CommentRepository {
    fun getComments(
        episodeId: Long,
        page: Int = 1,
    ): Flow<PagingData<Comment>>
}
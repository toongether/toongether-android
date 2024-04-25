package kr.toongether.network.datasource

import kr.toongether.network.model.CommentListResponse

interface CommentNetworkDataSource {
    suspend fun getComments(
        episodeId: Long,
        page: Int,
    ): CommentListResponse
}
package kr.toongether.network.datasource

interface LikeNetworkDataSource {
    suspend fun likeShorts(
        shortsId: Long
    ): Boolean

    suspend fun likeSeries(
        seriesEpisodeId: Long,
    ): Boolean
}

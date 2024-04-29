package kr.toongether.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.toongether.data.CommentRepository
import kr.toongether.data.EmailRepository
import kr.toongether.data.HomeRepository
import kr.toongether.data.LikeRepository
import kr.toongether.data.SeriesRepository
import kr.toongether.data.ShortsRepository
import kr.toongether.data.UserRepository
import kr.toongether.data.repository.CommentRepositoryImpl
import kr.toongether.data.repository.EmailRepositoryImpl
import kr.toongether.data.repository.HomeRepositoryImpl
import kr.toongether.data.repository.LikeRepositoryImpl
import kr.toongether.data.repository.SeriesRepositoryImpl
import kr.toongether.data.repository.ShortsRepositoryImpl
import kr.toongether.data.repository.UserRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun bindsSeriesRepository(
        seriesRepository: SeriesRepositoryImpl
    ): SeriesRepository

    @Binds
    fun bindsShortsRepository(
        shortsRepository: ShortsRepositoryImpl
    ): ShortsRepository

    @Binds
    fun bindsHomeRepository(
        homeRepository: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    fun bindsLikeRepository(
        likeRepository: LikeRepositoryImpl
    ): LikeRepository

    @Binds
    fun bindsEmailRepository(
        emailRepository: EmailRepositoryImpl
    ): EmailRepository

    @Binds
    fun bindsCommentRepository(
        commentRepository: CommentRepositoryImpl
    ): CommentRepository

    @Binds
    fun bindsUserRepository(
        userRepository: UserRepositoryImpl
    ): UserRepository
}

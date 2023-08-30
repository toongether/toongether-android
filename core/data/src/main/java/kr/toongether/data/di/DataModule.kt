package kr.toongether.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.toongether.data.ComicRepository
import kr.toongether.data.UserRepository
import kr.toongether.data.repository.ComicRepositoryImpl
import kr.toongether.data.repository.UserRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun bindsComicRepository(
        comicRepository: ComicRepositoryImpl
    ): ComicRepository

    @Binds
    fun bindsUserRepository(
        userRepository: UserRepositoryImpl
    ): UserRepository
}

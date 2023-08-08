package kr.toongether.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.toongether.data.repository.ComicRepository
import kr.toongether.data.repository.ComicRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsComicRepository(
        comicRepository: ComicRepositoryImpl
    ): ComicRepository
}
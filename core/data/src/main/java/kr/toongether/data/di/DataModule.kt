package kr.toongether.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.toongether.data.repository.WebtoonRepository
import kr.toongether.data.repository.WebtoonRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsWebtoonRepository(
        webtoonRepository: WebtoonRepositoryImpl
    ): WebtoonRepository
}
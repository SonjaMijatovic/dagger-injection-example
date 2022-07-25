package com.example.injectrepositories.di.module

import com.example.injectrepositories.repository.PostRepository
import com.example.injectrepositories.repository.PostRepositoryImpl
import com.example.injectrepositories.service.PostService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providePostRepository(postService: PostService): PostRepository {
        return PostRepositoryImpl(postService)
    }
}
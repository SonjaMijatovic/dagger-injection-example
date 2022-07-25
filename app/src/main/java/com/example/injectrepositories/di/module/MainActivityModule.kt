package com.example.injectrepositories.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.injectrepositories.viewmodel.PostViewModel
import com.example.injectrepositories.repository.PostRepository
import dagger.Module
import dagger.Provides

@Suppress("UNCHECKED_CAST")
@Module
class MainActivityModule {

    @Provides
    fun provideViewModelFactory(postRepository: PostRepository): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PostViewModel(postRepository) as T
            }
        }
    }
}
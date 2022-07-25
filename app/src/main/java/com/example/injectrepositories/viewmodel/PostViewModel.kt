package com.example.injectrepositories.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.injectrepositories.model.Post
import com.example.injectrepositories.repository.PostRepository

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    fun getPosts(): LiveData<List<Post>> = postRepository.getPosts()
}
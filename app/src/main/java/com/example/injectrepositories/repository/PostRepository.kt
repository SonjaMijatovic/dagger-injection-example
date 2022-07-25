package com.example.injectrepositories.repository

import androidx.lifecycle.LiveData
import com.example.injectrepositories.model.Post

interface PostRepository {

    fun getPosts() : LiveData<List<Post>>
}
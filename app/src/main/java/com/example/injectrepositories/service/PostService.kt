package com.example.injectrepositories.service

import com.example.injectrepositories.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun getPosts(): Call<List<Post>>
}
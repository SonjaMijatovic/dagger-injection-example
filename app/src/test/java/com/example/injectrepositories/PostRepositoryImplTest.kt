package com.example.injectrepositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.injectrepositories.model.Post
import com.example.injectrepositories.repository.PostRepositoryImpl
import com.example.injectrepositories.service.PostService
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class PostRepositoryImplTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @InjectMocks
    lateinit var postRepository: PostRepositoryImpl

    @Mock
    lateinit var postService: PostService

    @Mock
    lateinit var call: Call<List<Post>>

    @Before
    fun setUp() {
        Mockito.`when`(postService.getPosts()).thenReturn(call)
    }

    // TODO add generator for int and String
    @Test
    fun getPosts_success() {
        val randomPostList = listOf(
            Post(1, 1, "title1", "body1"),
            Post(2, 2, "title2", "body2")
        )
        Mockito.`when`(call.enqueue(Mockito.any())).thenAnswer {
            (it.arguments[0] as Callback<List<Post>>)
                .onResponse(call, Response.success(randomPostList))
        }
        val result = postRepository.getPosts()
        assertEquals(randomPostList, result.value)
    }
}
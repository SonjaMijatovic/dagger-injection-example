package com.example.injectrepositories

import androidx.lifecycle.LiveData
import com.example.injectrepositories.model.Post
import com.example.injectrepositories.repository.PostRepository
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostViewModelTest {

    @InjectMocks
    lateinit var postViewModel: PostViewModel

    @Mock
    lateinit var postRepository: PostRepository

    @Test
    fun getPosts() {
        val expected = Mockito.mock(LiveData::class.java)
        Mockito.`when`(postRepository.getPosts()).thenReturn(expected as LiveData<List<Post>>?)

        val result = postViewModel.getPosts()

        assertEquals(expected, result)
    }
}
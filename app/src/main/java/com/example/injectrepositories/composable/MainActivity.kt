package com.example.injectrepositories.composable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.injectrepositories.Application
import com.example.injectrepositories.model.Post
import com.example.injectrepositories.viewmodel.PostViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as Application).applicationComponent.createActivitySubcomponent().inject(this)

        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AllPosts(listOf(Post(1, 1, "df", "vgb")))
                }
            }

            val viewModel = ViewModelProvider(this, factory).get(PostViewModel::class.java)
            viewModel.getPosts().observe(this, Observer {
                Log.e("received Data", "MainActivity")
                // updatePosts in UI
            })
        }
    }
}
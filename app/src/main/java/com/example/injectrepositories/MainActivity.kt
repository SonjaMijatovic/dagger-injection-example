package com.example.injectrepositories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.injectrepositories.viewmodel.PostViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as Application).applicationComponent.createActivitySubcomponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this, factory).get(PostViewModel::class.java)
        viewModel.getPosts().observe(this, Observer {
            // updatePosts in UI
        })
    }
}
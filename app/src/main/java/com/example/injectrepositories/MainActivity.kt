package com.example.injectrepositories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.injectrepositories.viewmodel.PostViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as Application).applicationComponent.createActivitySubcomponent().inject(this)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val greeting = findViewById<ComposeView>(R.id.greeting)
        greeting.setContent {
            Greeting()
        }


        val viewModel = ViewModelProvider(this, factory).get(PostViewModel::class.java)
        viewModel.getPosts().observe(this, Observer {
            // updatePosts in UI
        })
    }
}

@Composable
private fun Greeting() {
    Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}
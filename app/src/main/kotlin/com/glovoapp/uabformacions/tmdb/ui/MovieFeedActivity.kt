package com.glovoapp.uabformacions.tmdb.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.glovoapp.uabformacions.tmdb.domain.MovieFeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFeedActivity : ComponentActivity() {

    private val viewModel: MovieFeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieFeedScreen(viewModel)
        }
    }
}

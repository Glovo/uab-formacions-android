package com.glovoapp.uabformacions.dogapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedsActivity : ComponentActivity() {

    private val viewModel: BreedsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BreedsScreen(
                breeds = viewModel.breeds.collectAsState().value,
            )
        }
    }

}

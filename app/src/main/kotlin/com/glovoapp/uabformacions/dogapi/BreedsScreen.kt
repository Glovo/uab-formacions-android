package com.glovoapp.uabformacions.dogapi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun BreedsScreen(
    breeds: List<String> = listOf("Husky", "Pug", "Beagle"),
) = MaterialTheme {
    LazyColumn {
        items(breeds.size) { i ->
            Button(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Text(text = breeds[i])
            }
        }
    }
}

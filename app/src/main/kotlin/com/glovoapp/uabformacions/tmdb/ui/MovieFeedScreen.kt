package com.glovoapp.uabformacions.tmdb.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.glovoapp.uabformacions.tmdb.data.dtos.Movie
import com.glovoapp.uabformacions.tmdb.domain.MovieFeedViewModel
import com.glovoapp.uabformacions.tmdb.domain.MovieFeedViewModel.SortingOption


@Composable
fun MovieFeedScreen(
    viewModel: MovieFeedViewModel
) {
    val movieList by viewModel.movies.collectAsState()
    val selectedSortingOption by viewModel.selectedSortingOption.collectAsState()

    ScreenContent(movieList, selectedSortingOption, viewModel::onSortingOptionSelected)
}

@Composable
fun ScreenContent(movieList: List<Movie>, selectedSortingOption: SortingOption, onSortingOptionSelected: (SortingOption) -> Unit) {
    MaterialTheme {
        Column {
            TopAppBar(title = { Text(text = "Movie feed") })
            SortOptionsRow(selectedSortingOption, onSortingOptionSelected)
            LazyColumn {
                items(movieList.size) { i ->
                    MovieCard(movieList[i])
                }
            }
        }
    }
}

@Composable
fun SortOptionsRow(
    selectedSortingOption: SortingOption,
    onOptionSelected: (SortingOption) -> Unit
) {
    val sortingOptions = SortingOption.entries

    Column(modifier = Modifier.background(Color.White)) {
        Text(
            text = "Sort by:",
            style = MaterialTheme.typography.h6,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            sortingOptions.forEach { option ->
                Button(
                    onClick = {
                        onOptionSelected(option)
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (selectedSortingOption == option) MaterialTheme.colors.primary else MaterialTheme.colors.surface
                    )
                ) {
                    Text(
                        text = option.displayName,
                        color = if (selectedSortingOption == option) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column {
            // Backdrop Image
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.backdropPath}",
                contentDescription = "${movie.title} backdrop",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Movie Title
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = movie.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Movie Overview
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = movie.overview,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    text = "Release: ${movie.releaseDate}",
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Rating: ${movie.voteAverage}/10",
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Popularity: ${movie.popularity.toInt()}",
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview
@Composable
fun Preview() {
    val movies = listOf(
        Movie(
            adult = false,
            backdropPath = "/3V4kLQg0kSqPLctI5ziYWabAZYF.jpg",
            genreIds = listOf(878, 28, 12),
            id = 912649,
            originalLanguage = "en",
            originalTitle = "Venom: The Last Dance",
            overview = "Eddie and Venom are on the run. Hunted by both of their worlds and with the net closing in, the duo are forced into a devastating decision that will bring the curtains down on Venom and Eddie's last dance.",
            popularity = 3197.278,
            posterPath = "/aosm8NMQ3UyoBVpSxyimorCQykC.jpg",
            releaseDate = "2024-10-22",
            title = "Venom: The Last Dance",
            video = false,
            voteAverage = 6.5f,
            voteCount = 759
        ),
        Movie(
            adult = false,
            backdropPath = "/18TSJF1WLA4CkymvVUcKDBwUJ9F.jpg",
            genreIds = listOf(27, 53, 9648),
            id = 1034541,
            originalLanguage = "en",
            originalTitle = "Terrifier 3",
            overview = "Five years after surviving Art the Clown's Halloween massacre, Sienna and Jonathan are still struggling to rebuild their shattered lives. As the holiday season approaches, they try to embrace the Christmas spirit and leave the horrors of the past behind. But just when they think they're safe, Art returns, determined to turn their holiday cheer into a new nightmare. The festive season quickly unravels as Art unleashes his twisted brand of terror, proving that no holiday is safe.",
            popularity = 2204.248,
            posterPath = "/l1175hgL5DoXnqeZQCcU3eZIdhX.jpg",
            releaseDate = "2024-10-09",
            title = "Terrifier 3",
            video = false,
            voteAverage = 6.928f,
            voteCount = 1013
        ),
        Movie(
            adult = false,
            backdropPath = "/v9acaWVVFdZT5yAU7J2QjwfhXyD.jpg",
            genreIds = listOf(16, 878, 10751),
            id = 1184918,
            originalLanguage = "en",
            originalTitle = "The Wild Robot",
            overview = "After a shipwreck, an intelligent robot called Roz is stranded on an uninhabited island. To survive the harsh environment, Roz bonds with the island's animals and cares for an orphaned baby goose.",
            popularity = 1868.856,
            posterPath = "/wTnV3PCVW5O92JMrFvvrRcV39RU.jpg",
            releaseDate = "2024-09-12",
            title = "The Wild Robot",
            video = false,
            voteAverage = 8.5f,
            voteCount = 2900
        )
    )
    ScreenContent(movies, SortingOption.POPULARITY, {})
}
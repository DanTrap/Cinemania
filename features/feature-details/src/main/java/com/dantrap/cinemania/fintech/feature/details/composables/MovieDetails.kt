package com.dantrap.cinemania.fintech.feature.details.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.core.domain.model.MovieDetails
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.core.ui.components.MovieRating

@Composable
internal fun MovieDetails(movieDetails: MovieDetails) {
    Surface {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                text = movieDetails.name,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.W800,
                    textAlign = TextAlign.Center
                )
            )
            if (movieDetails.ratingKinopoisk != 0.0) {
                MovieRating(
                    rating = movieDetails.ratingKinopoisk,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .wrapContentWidth(),
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 48.dp),
                text = stringResource(
                    R.string.year_genres,
                    movieDetails.year,
                    movieDetails.genres.joinToString()
                ),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 48.dp),
                text = movieDetails.countries.joinToString(),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center
                )
            )
            if (movieDetails.filmLength != 0) {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    text = movieDetails.filmLength.toHoursMinsString(),
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.W400,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                text = movieDetails.description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun Int.toHoursMinsString(): String {
    val hours = this / 60
    val mins = this - 60 * hours
    return if (hours == 0) {
        stringResource(R.string.mins, mins)
    } else if (mins == 0) {
        stringResource(R.string.hours, hours)
    } else {
        stringResource(R.string.hours_mins, hours, mins)
    }
}

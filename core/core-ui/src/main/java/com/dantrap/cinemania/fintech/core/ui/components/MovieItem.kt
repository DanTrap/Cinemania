package com.dantrap.cinemania.fintech.core.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.ui.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieItem(
    movie: Movie,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    onLongClick: () -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        shadowElevation = 6.dp,
        tonalElevation = 1.dp
    ) {
        Box(
            modifier = Modifier
                .height(140.dp)
                .combinedClickable(
                    onClick = onClick,
                    onLongClick = onLongClick
                )
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                MoviePosterPreview(
                    model = movie.posterUrlPreview,
                    modifier = Modifier.weight(weight = 1f)
                )
                MovieNameYearGenre(
                    name = movie.name,
                    genre = movie.genre,
                    year = movie.year,
                    modifier = Modifier.weight(weight = 3f)
                )
            }
            MovieFavoriteBadge(
                isFavorite = movie.isFavorite,
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight()
            )
            if (movie.ratingKinopoisk != 0.0) {
                MovieRating(
                    rating = movie.ratingKinopoisk,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
    }
}

@Composable
private fun MoviePosterPreview(model: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = model,
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .fillMaxHeight()
            .aspectRatio(0.5f),
        contentScale = ContentScale.FillBounds,
        contentDescription = null
    )
}

@Composable
private fun MovieNameYearGenre(
    name: String,
    genre: String,
    year: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.W700
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.genre_year, genre, year),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.W500
            )
        )
    }
}

@Composable
private fun MovieFavoriteBadge(isFavorite: Boolean, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        if (isFavorite) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Rounded.Star,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = null
            )
        } else {
            Spacer(modifier = Modifier.width(24.dp))
        }
    }
}

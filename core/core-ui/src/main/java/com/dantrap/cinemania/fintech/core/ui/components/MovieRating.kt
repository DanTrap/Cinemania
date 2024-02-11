package com.dantrap.cinemania.fintech.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.core.ui.theme.AverageMovieColor
import com.dantrap.cinemania.fintech.core.ui.theme.GoodMovieColor
import com.dantrap.cinemania.fintech.core.ui.theme.PoorMovieColor

@Composable
fun MovieRating(rating: Double, modifier: Modifier = Modifier) {
    val startRating = 0
    val middleRating = 5
    val goodRating = 7
    val background = when {
        rating > startRating && rating < middleRating -> PoorMovieColor
        rating >= middleRating && rating < goodRating -> AverageMovieColor
        else -> GoodMovieColor
    }
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .background(background)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = rating.toString(),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.W900,
                color = Color.White
            )
        )
    }
}

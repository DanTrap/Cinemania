package com.dantrap.cinemania.fintech.feature.favorite.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.core.ui.R

@Composable
internal fun EmptyFavoritesDatabase(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        )
    ) {
        Icon(
            imageVector = Icons.Rounded.BookmarkBorder,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(64.dp),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.empty_favorites_database),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.W700,
                textAlign = TextAlign.Center
            )
        )
    }
}

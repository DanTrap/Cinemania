package com.dantrap.cinemania.fintech.core.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState

@Composable
fun RefreshState(
    refresh: LoadState,
    isListEmpty: Boolean,
    errorMessage: String,
    modifier: Modifier = Modifier,
    onRetry: () -> Unit,
) {
    when (refresh) {
        is LoadState.Loading -> if (isListEmpty) CircularProgressIndicator(modifier = modifier)

        is LoadState.Error -> if (isListEmpty) {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterVertically
                )
            ) {
                Text(
                    text = errorMessage,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W700)
                )
                Icon(
                    imageVector = Icons.Rounded.Refresh,
                    modifier = Modifier
                        .size(54.dp)
                        .clip(CircleShape)
                        .clickable { onRetry() }
                        .padding(8.dp),
                    contentDescription = null
                )
            }
        }

        is LoadState.NotLoading -> Unit
    }
}

@Composable
fun AppendState(
    append: LoadState,
    isListEmpty: Boolean,
    modifier: Modifier = Modifier,
    onRetry: () -> Unit,
) {
    when (append) {
        is LoadState.Loading -> if (!isListEmpty) CircularProgressIndicator(modifier = modifier)

        is LoadState.Error -> Icon(
            imageVector = Icons.Rounded.Refresh,
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
                .clickable { onRetry() }
                .padding(8.dp),
            contentDescription = null
        )

        is LoadState.NotLoading -> Unit
    }
}

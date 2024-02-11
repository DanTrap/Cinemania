package com.dantrap.cinemania.fintech.feature.favorite.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.feature.favorite.state.FavoriteEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FavoriteTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier,
    onEvent: (FavoriteEvent) -> Unit,
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(id = R.string.favorite),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.W500
                )
            )
        },
        actions = {
            IconButton(onClick = { onEvent(FavoriteEvent.OnSettingsClick) }) {
                Icon(
                    imageVector = Icons.Rounded.Settings,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = null
                )
            }
        }
    )
}

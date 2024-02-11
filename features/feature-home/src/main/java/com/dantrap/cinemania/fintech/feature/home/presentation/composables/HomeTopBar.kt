package com.dantrap.cinemania.fintech.feature.home.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.feature.home.presentation.states.HomeEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier,
    onEvent: (HomeEvent) -> Unit,
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(id = R.string.popular),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.W500
                )
            )
        },
        actions = {
            IconButton(onClick = { onEvent(HomeEvent.OnSettingsClick) }) {
                Icon(
                    imageVector = Icons.Rounded.Settings,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = null
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun HomeTopBarPreview() {
    HomeTopBar(
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    ) {}
}

package com.dantrap.cinemania.fintech.feature.settings.menu.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.feature.settings.menu.states.SettingsEvent

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onEvent: (SettingsEvent) -> Unit
) {
    Scaffold(
        topBar = { SettingsTopBar { onEvent(SettingsEvent.OnBackArrowClick) } }
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SettingsDestinationsColumn(
                buttons = settingsButtons(onEvent = onEvent)
            )
        }
    }
}

@Composable
private fun SettingsDestinationsColumn(buttons: List<SettingsButtonContent>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.Top
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(buttons) {
            SettingsButton(
                modifier = Modifier.fillMaxWidth(),
                text = it.text,
                imageVector = it.imageVector,
                onClick = { it.onClick() }
            )
        }
    }
}

@Preview
@Composable
private fun SettingScreenPreview() {
    SettingsScreen {}
}

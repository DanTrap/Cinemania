package com.dantrap.cinemania.fintech.feature.settings.language.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.feature.settings.language.states.LanguageEvent
import com.dantrap.cinemania.fintech.feature.settings.language.states.LanguageState

@Composable
fun LanguageScreen(
    state: LanguageState,
    modifier: Modifier = Modifier,
    onEvent: (LanguageEvent) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = { LanguageTopBar(onEvent = onEvent) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.Top
            ),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(state.mapLocales.map { it.value }) { language ->
                LanguageItem(
                    language = language,
                    isCurrentLanguage = language == state.currentLanguage
                ) {
                    onEvent(LanguageEvent.ChangeLanguage(language))
                }
            }
        }
    }
}

@Preview
@Composable
private fun LanguageScreenPreview() {
    LanguageScreen(
        state = LanguageState(
            mapLocales = mapOf("English" to "en", "Русский" to "ru")
        )
    ) {}
}

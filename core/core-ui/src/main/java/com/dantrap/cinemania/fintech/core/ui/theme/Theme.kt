package com.dantrap.cinemania.fintech.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

val ColorScheme = darkColorScheme(
    background = BackgroundColor,
    // Text
    onPrimary = TextColor,
    // TopBar
    surface = BackgroundColor,
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ColorScheme,
        typography = Typography,
        content = content
    )
}

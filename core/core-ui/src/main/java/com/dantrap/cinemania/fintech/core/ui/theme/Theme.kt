package com.dantrap.cinemania.fintech.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val LightColorScheme = lightColorScheme(
    primary = LightPrimaryColor,
    background = LightBackgroundColor,
    surface = LightBackgroundColor,
    onPrimary = LightTextColor,
    onSecondaryContainer = LightPrimaryColor
)

val DarkColorScheme = darkColorScheme(
    primary = DarkPrimaryColor,
    background = DarkBackgroundColor,
    surface = DarkBackgroundColor,
    onPrimary = DarkTextColor,
    onSecondaryContainer = DarkPrimaryColor
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}

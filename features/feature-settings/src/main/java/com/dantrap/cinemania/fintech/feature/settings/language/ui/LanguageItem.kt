package com.dantrap.cinemania.fintech.feature.settings.language.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.core.ui.components.MainButton

@Composable
internal fun LanguageItem(
    language: String,
    isCurrentLanguage: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val containerColor = if (isCurrentLanguage) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
    }

    val contentColor = if (isCurrentLanguage) {
        MaterialTheme.colorScheme.background
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    MainButton(
        modifier = modifier.fillMaxWidth(),
        containerColor = containerColor,
        contentColor = contentColor,
        onClick = { onClick() }
    ) {
        Box(modifier = Modifier.wrapContentSize()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                language.toLanguagePair().let { pair ->
                    Text(text = pair.first)
                    Text(
                        text = pair.second,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }
            if (isCurrentLanguage) {
                Icon(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    imageVector = Icons.Rounded.Check,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
private fun String.toLanguagePair(): Pair<String, String> {
    return when (this) {
        "ru" -> stringResource(R.string.ru) to stringResource(R.string.russian)
        else -> stringResource(R.string.en) to stringResource(R.string.english)
    }
}

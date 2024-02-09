package com.dantrap.cinemania.fintech.feature.settings.menu.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.material.icons.rounded.PrivacyTip
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.feature.settings.menu.states.SettingsEvent

@Composable
fun settingsButtons(onEvent: (SettingsEvent) -> Unit): List<SettingsButtonContent> = listOf(
    SettingsButtonContent(
        text = stringResource(R.string.privacy_policy),
        imageVector = Icons.Rounded.PrivacyTip,
        onClick = { onEvent(SettingsEvent.OnPrivacyPolicyClick) }
    ),
    SettingsButtonContent(
        text = stringResource(id = R.string.terms_of_use),
        imageVector = Icons.Rounded.Description,
        onClick = { onEvent(SettingsEvent.OnTermsClick) }
    ),
    SettingsButtonContent(
        text = stringResource(R.string.contact_us),
        imageVector = Icons.Rounded.Mail,
        onClick = { onEvent(SettingsEvent.OnContactUsClick) }
    ),
    SettingsButtonContent(
        text = stringResource(R.string.language),
        imageVector = Icons.Rounded.Language,
        onClick = { onEvent(SettingsEvent.OnLanguageClick) }
    ),
    SettingsButtonContent(
        text = stringResource(R.string.rate_us),
        imageVector = Icons.Rounded.Star,
        onClick = { onEvent(SettingsEvent.OnRateUsClick) }
    )
)

data class SettingsButtonContent(
    val text: String,
    val imageVector: ImageVector,
    val onClick: () -> Unit
)

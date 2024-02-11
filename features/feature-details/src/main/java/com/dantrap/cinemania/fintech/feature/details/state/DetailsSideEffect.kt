package com.dantrap.cinemania.fintech.feature.details.state

import androidx.compose.runtime.Immutable

@Immutable
sealed class DetailsSideEffect {
    data object NavigateBack : DetailsSideEffect()
}

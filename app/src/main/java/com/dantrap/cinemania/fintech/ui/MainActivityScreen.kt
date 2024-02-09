package com.dantrap.cinemania.fintech.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dantrap.cinemania.fintech.core.ui.theme.AppTheme
import com.dantrap.cinemania.fintech.navigation.Navigation

@Composable
fun MainActivityScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
) {
    AppTheme {
        Surface {
            Navigation(navHostController = navHostController, modifier = modifier)
        }
    }
}

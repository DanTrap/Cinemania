package com.dantrap.cinemania.fintech.feature.settings.terms.ui

import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.core.ui.components.ProgressLottieAnimation
import com.dantrap.cinemania.fintech.feature.settings.terms.states.TermsEvent
import com.dantrap.cinemania.fintech.feature.settings.terms.states.TermsState
import com.google.accompanist.web.LoadingState
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewNavigator
import com.google.accompanist.web.rememberWebViewState

@Composable
fun TermsScreen(state: TermsState, modifier: Modifier = Modifier, onEvent: (TermsEvent) -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = { TermsTopBar(onEvent = onEvent) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (state.url.isEmpty()) {
                true -> ProgressLottieAnimation(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(200.dp),
                    rawAnimId = R.raw.lottie_ball_animation
                )

                else -> PrivacyScreenContent(url = state.url)
            }
        }
    }
}

@Composable
private fun PrivacyScreenContent(url: String) {
    val navigator = rememberWebViewNavigator()
    val state = rememberWebViewState(url = url)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        val loadingState = state.loadingState
        if (loadingState is LoadingState.Loading) {
            LinearProgressIndicator(
                progress = loadingState.progress,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        WebView(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            state = state,
            navigator = navigator,
            onCreated = { webView ->
                webSettings(webView)
            }
        )
    }
}

@SuppressLint("SetJavaScriptEnabled")
private fun webSettings(webView: WebView) {
    with(webView.settings) {
        javaScriptEnabled = true
        useWideViewPort = true
        loadWithOverviewMode = true
        cacheMode = WebSettings.LOAD_NO_CACHE
    }
}

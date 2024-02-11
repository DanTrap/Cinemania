package com.dantrap.cinemania.fintech.core.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.core.common.network.ResponseError
import com.dantrap.cinemania.fintech.core.ui.R

@Composable
fun ErrorDialog(
    error: ResponseError,
    modifier: Modifier = Modifier,
    onRetry: () -> Unit,
) {
    Surface(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ErrorText(error = error)
            Icon(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .clickable { onRetry() }
                    .padding(8.dp),
                imageVector = Icons.Rounded.Refresh,
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun ErrorText(error: ResponseError, modifier: Modifier = Modifier) {
    val text = when (error) {
        ResponseError.BAD_REQUEST -> stringResource(id = R.string.http_bad_request)
        ResponseError.UNAUTHORIZED -> stringResource(id = R.string.http_unauthorized)
        ResponseError.FORBIDDEN -> stringResource(id = R.string.http_forbidden)
        ResponseError.NOT_FOUND -> stringResource(id = R.string.http_not_found)
        ResponseError.INTERNAL_SERVER -> stringResource(id = R.string.http_internal_server_error)
        ResponseError.CONNECTION -> stringResource(id = R.string.connection_exception)
        ResponseError.UNKNOWN_HOST -> stringResource(id = R.string.host_exception)
        ResponseError.SOCKET_TIMEOUT -> stringResource(id = R.string.socket_exception)
        ResponseError.SSL -> stringResource(id = R.string.ssl_exception)
        ResponseError.UNEXPECTED -> stringResource(id = R.string.unexpected_error)
    }
    Text(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W700)
    )
}

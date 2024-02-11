package com.dantrap.cinemania.fintech.feature.search.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.feature.search.state.SearchEvent
import com.dantrap.cinemania.fintech.feature.search.state.SearchState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchTopBar(
    state: SearchState,
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier,
    onEvent: (SearchEvent) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    TopAppBar(
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        title = {
            SearchBar(
                query = state.query,
                onQueryChange = { onEvent(SearchEvent.OnUserInput(it)) },
                onSearch = {
                    focusManager.clearFocus()
                    onEvent(SearchEvent.OnSearch(it))
                },
                active = state.isSearchActive,
                onActiveChange = {},
                placeholder = { Text(text = stringResource(R.string.search_movie_hint)) },
                trailingIcon = {
                    if (state.query.isNotEmpty()) {
                        IconButton(onClick = { onEvent(SearchEvent.OnClearClick) }) {
                            Icon(
                                imageVector = Icons.Rounded.Close,
                                contentDescription = null
                            )
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 16.dp, top = 16.dp)
            ) {}
        }
    )
}

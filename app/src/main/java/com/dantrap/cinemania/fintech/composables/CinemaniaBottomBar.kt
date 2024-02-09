package com.dantrap.cinemania.fintech.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dantrap.cinemania.fintech.core.ui.R
import com.dantrap.cinemania.fintech.core.ui.theme.LightPrimaryColor
import com.dantrap.cinemania.fintech.utils.Destination

@Composable
fun CinemaniaBottomBar(navController: NavHostController, modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier, tonalElevation = 0.dp) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        bottomBarDestinations().forEach { item ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.name
                    )
                },
                label = { Text(text = item.name, style = MaterialTheme.typography.labelSmall) },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightPrimaryColor,
                    selectedTextColor = LightPrimaryColor,
                    unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                    indicatorColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    }
}

@Immutable
data class BottomBarItem(
    val name: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@Composable
private fun bottomBarDestinations() = listOf(
    BottomBarItem(
        name = stringResource(id = R.string.home),
        route = Destination.AppGraph.Home(),
        selectedIcon = Icons.Rounded.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomBarItem(
        name = stringResource(id = R.string.favorite),
        route = Destination.AppGraph.Favorite(),
        selectedIcon = Icons.Rounded.Star,
        unselectedIcon = Icons.Rounded.StarOutline
    ),
    BottomBarItem(
        name = stringResource(id = R.string.search),
        route = Destination.AppGraph.Search(),
        selectedIcon = Icons.Rounded.Search,
        unselectedIcon = Icons.Rounded.Search
    )
)

package com.dantrap.cinemania.fintech.utils

internal sealed class Destination(protected val route: String, vararg params: String) {

    private val fullRoute: String = if (params.isEmpty()) {
        route
    } else {
        StringBuilder(route).apply {
            params.forEach { append("/{$it}") }
        }.toString()
    }

    operator fun invoke() = fullRoute

    internal fun String.appendParams(params: List<String>): String {
        return StringBuilder(this).apply {
            params.forEach { append("/$it") }
        }.toString()
    }

    data object AppGraph : Destination("app_route") {

        data object Home : Destination("home_route")

        data object Favorite : Destination("favorite_route")

        data object Search : Destination("search_route")

        data object Movie : Destination("movie_route", "id") {
            operator fun invoke(id: Int) = route.appendParams(listOf(id.toString()))
        }

        data object SettingsGraph : Destination("settingsGraph") {
            data object Settings : Destination("settings")
            data object Language : Destination("language")
            data object Privacy : Destination("privacy")
            data object Terms : Destination("terms")
        }
    }
}

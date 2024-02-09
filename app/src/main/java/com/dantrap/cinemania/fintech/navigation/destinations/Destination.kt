package com.dantrap.cinemania.fintech.navigation.destinations

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

    data object AppGraph : Destination("stubGraph") {
        data object Home : Destination("home")
        data object SettingsGraph : Destination("settingsGraph") {
            data object Settings : Destination("settings")
            data object Language : Destination("language")
            data object Privacy : Destination("privacy")
            data object Terms : Destination("terms")
        }
    }
}

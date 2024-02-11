package com.dantrap.cinemania.fintech.core.domain.model

data class MovieDetails(
    val kinopoiskId: Int,
    val genres: List<String>,
    val nameOriginal: String,
    val nameRu: String,
    val posterUrl: String,
    val ratingKinopoisk: Double,
    val year: Int,
    val countries: List<String>,
    val description: String,
    val filmLength: Int,
    val ratingAgeLimits: String?,
)

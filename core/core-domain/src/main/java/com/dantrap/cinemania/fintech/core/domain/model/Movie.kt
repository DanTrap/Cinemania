package com.dantrap.cinemania.fintech.core.domain.model

data class Movie(
    val kinopoiskId: Int,
    val genre: String,
    val nameOriginal: String,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val ratingKinopoisk: Double,
    val year: Int,
    val isFavorite: Boolean = false
)

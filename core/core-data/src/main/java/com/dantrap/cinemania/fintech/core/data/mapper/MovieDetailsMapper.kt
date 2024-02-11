package com.dantrap.cinemania.fintech.core.data.mapper

import com.dantrap.cinemania.fintech.core.domain.model.MovieDetails
import com.dantrap.cinemania.fintech.core.network.model.MovieDetailsDto

internal fun MovieDetailsDto.toDomain(): MovieDetails = MovieDetails(
    kinopoiskId = kinopoiskId,
    genres = genres.map { it.genre },
    nameOriginal = nameOriginal ?: "",
    nameRu = nameRu,
    posterUrl = posterUrl,
    ratingKinopoisk = ratingKinopoisk ?: 0.0,
    year = year,
    countries = countries.map { it.country },
    description = description,
    filmLength = filmLength,
    ratingAgeLimits = ratingAgeLimits ?: ""
)

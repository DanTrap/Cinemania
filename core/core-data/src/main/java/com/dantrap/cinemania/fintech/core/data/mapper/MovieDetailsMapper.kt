package com.dantrap.cinemania.fintech.core.data.mapper

import com.dantrap.cinemania.fintech.core.common.utils.Constants
import com.dantrap.cinemania.fintech.core.domain.model.MovieDetails
import com.dantrap.cinemania.fintech.core.network.model.MovieDetailsDto

internal fun MovieDetailsDto.toDomain(): MovieDetails = MovieDetails(
    kinopoiskId = kinopoiskId,
    genres = genres.map { it.genre },
    name = nameRu ?: nameOriginal ?: Constants.NOT_AVAILABLE,
    posterUrl = posterUrl ?: Constants.STUB_POSTER,
    ratingKinopoisk = ratingKinopoisk ?: 0.0,
    year = year ?: 0,
    countries = countries.map { it.country },
    description = description,
    filmLength = filmLength,
    ratingAgeLimits = ratingAgeLimits ?: ""
)

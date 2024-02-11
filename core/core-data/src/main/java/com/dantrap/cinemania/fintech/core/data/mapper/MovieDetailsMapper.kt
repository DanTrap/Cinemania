package com.dantrap.cinemania.fintech.core.data.mapper

import com.dantrap.cinemania.fintech.core.common.utils.Constants
import com.dantrap.cinemania.fintech.core.database.model.MovieDetailsEntity
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
    description = description ?: Constants.NOT_AVAILABLE,
    filmLength = filmLength ?: 0,
    ratingAgeLimits = ratingAgeLimits ?: ""
)

internal fun MovieDetailsEntity.toDomain(): MovieDetails = MovieDetails(
    kinopoiskId = kinopoiskId,
    genres = genres,
    name = name,
    posterUrl = posterUrl,
    ratingKinopoisk = ratingKinopoisk,
    year = year,
    countries = countries,
    description = description,
    filmLength = filmLength,
    ratingAgeLimits = ratingAgeLimits ?: ""
)

internal fun MovieDetailsDto.toEntity(): MovieDetailsEntity = MovieDetailsEntity(
    kinopoiskId = kinopoiskId,
    genres = genres.map { it.genre },
    name = nameRu ?: nameOriginal ?: Constants.NOT_AVAILABLE,
    posterUrl = posterUrl ?: Constants.STUB_POSTER,
    ratingKinopoisk = ratingKinopoisk ?: 0.0,
    year = year ?: 0,
    countries = countries.map { it.country },
    description = description ?: Constants.NOT_AVAILABLE,
    filmLength = filmLength ?: 0,
    ratingAgeLimits = ratingAgeLimits ?: ""
)

package com.dantrap.cinemania.fintech.core.data.mapper

import com.dantrap.cinemania.fintech.core.common.utils.Constants
import com.dantrap.cinemania.fintech.core.database.model.MovieEntity
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.network.model.MovieDto

internal fun MovieDto.toDomain(): Movie = Movie(
    kinopoiskId = idOldApi ?: kinopoiskId,
    genre = if (genres.isNotEmpty()) genres.first().genre else Constants.NOT_AVAILABLE,
    name = nameRu ?: nameOriginal ?: Constants.NOT_AVAILABLE,
    posterUrl = posterUrl ?: Constants.STUB_POSTER,
    posterUrlPreview = posterUrlPreview ?: Constants.STUB_POSTER,
    ratingKinopoisk = if (ratingOldApi == "null") ratingKinopoisk
        ?: 0.0 else ratingOldApi?.toDouble() ?: ratingKinopoisk ?: 0.0,
    year = year ?: 0
)

internal fun Movie.toEntity(): MovieEntity = MovieEntity(
    kinopoiskId = kinopoiskId,
    genre = genre,
    name = name,
    posterUrl = posterUrl,
    posterUrlPreview = posterUrlPreview,
    ratingKinopoisk = ratingKinopoisk,
    year = year
)

internal fun MovieEntity.toDomain(): Movie = Movie(
    kinopoiskId = kinopoiskId,
    genre = genre,
    name = name,
    posterUrl = posterUrl,
    posterUrlPreview = posterUrlPreview,
    ratingKinopoisk = ratingKinopoisk,
    year = year,
    isFavorite = true
)

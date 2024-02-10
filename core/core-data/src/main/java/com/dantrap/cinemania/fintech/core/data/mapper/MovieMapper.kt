package com.dantrap.cinemania.fintech.core.data.mapper

import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.network.model.MovieDto

internal fun MovieDto.toDomain(): Movie = Movie(
    kinopoiskId = kinopoiskId,
    genre = genres.first().genre,
    nameOriginal = nameOriginal ?: "",
    nameRu = nameRu,
    posterUrl = posterUrl,
    posterUrlPreview = posterUrlPreview,
    ratingKinopoisk = ratingKinopoisk ?: 0.0,
    year = year
)

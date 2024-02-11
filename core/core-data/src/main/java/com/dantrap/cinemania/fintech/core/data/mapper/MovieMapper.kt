package com.dantrap.cinemania.fintech.core.data.mapper

import com.dantrap.cinemania.fintech.core.common.utils.Constants
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.network.model.MovieDto

internal fun MovieDto.toDomain(): Movie = Movie(
    kinopoiskId = kinopoiskId,
    genre = genres.first().genre,
    name = nameRu ?: nameOriginal ?: Constants.NOT_AVAILABLE,
    posterUrl = posterUrl ?: Constants.STUB_POSTER,
    posterUrlPreview = posterUrlPreview ?: Constants.STUB_POSTER,
    ratingKinopoisk = ratingKinopoisk ?: 0.0,
    year = year ?: 0
)

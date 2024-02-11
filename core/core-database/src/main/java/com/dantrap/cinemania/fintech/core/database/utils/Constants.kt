package com.dantrap.cinemania.fintech.core.database.utils

internal object Constants {
    internal object Tables {
        internal const val FAVORITE_MOVIES = "favorite_movies"
        internal const val FAVORITE_MOVIES_DETAILS = "favorite_movies_details"
    }

    internal object Fields {
        internal const val ID = "id"
        internal const val KINOPOISK_ID = "kinopoisk_id"
        internal const val GENRE = "genre"
        internal const val NAME = "name_ru"
        internal const val POSTER_URL = "poster_url"
        internal const val POSTER_URL_PREVIEW = "poster_url_preview"
        internal const val RATING_KINOPOISK = "rating_kinopoisk"
        internal const val YEAR = "year"
        internal const val GENRES = "genres"
        internal const val COUNTRIES = "countries"
        internal const val DESCRIPTION = "description"
        internal const val FILM_LENGTH = "film_length"
        internal const val AGE_LIMITS = "age_limits"
    }
}

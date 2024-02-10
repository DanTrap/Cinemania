package com.dantrap.cinemania.fintech.core.network.utils

internal object Constants {
    internal const val API_URL = "https://kinopoiskapiunofficial.tech/"
    internal const val API_KEY_HEADER_PARAM = "x-api-key"
    internal const val DEFAULT_PAGE = 1
    internal const val POPULAR_MOVIES_TYPE = "TOP_POPULAR_MOVIES"

    internal object Path {
        internal const val MOVIE_COLLECTIONS = "api/v2.2/films/collections"
        internal const val MOVIE_INFO = "api/v2.2/films/{id}"
    }

    internal object Fields {
        internal const val TYPE = "type"
        internal const val PAGE = "page"
        internal const val ID = "id"
    }
}

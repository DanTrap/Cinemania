package com.dantrap.cinemania.fintech.core.network.model

import com.google.gson.annotations.SerializedName

data class SearchMovieResponseDto(
    @SerializedName("films")
    val movies: List<MovieDto>,
    @SerializedName("pagesCount")
    val pagesCount: Int,
)

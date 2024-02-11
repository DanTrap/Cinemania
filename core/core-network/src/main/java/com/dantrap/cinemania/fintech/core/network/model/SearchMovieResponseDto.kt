package com.dantrap.cinemania.fintech.core.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SearchMovieResponseDto(
    @SerializedName("films")
    val movies: List<MovieDto>,
    @SerializedName("pagesCount")
    val pagesCount: Int,
)

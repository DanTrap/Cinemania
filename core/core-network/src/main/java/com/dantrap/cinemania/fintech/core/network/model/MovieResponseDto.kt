package com.dantrap.cinemania.fintech.core.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieResponseDto(
    @SerializedName("items")
    val movies: List<MovieDto>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)

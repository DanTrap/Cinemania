package com.dantrap.cinemania.fintech.core.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieDto(
    @SerializedName("genres")
    val genres: List<GenreDto>,
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int,
    @SerializedName("nameOriginal")
    val nameOriginal: String?,
    @SerializedName("nameRu")
    val nameRu: String,
    @SerializedName("posterUrl")
    val posterUrl: String,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String,
    @SerializedName("ratingKinopoisk")
    val ratingKinopoisk: Double?,
    @SerializedName("year")
    val year: Int
)

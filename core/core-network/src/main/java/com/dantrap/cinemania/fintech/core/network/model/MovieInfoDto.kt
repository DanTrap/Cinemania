package com.dantrap.cinemania.fintech.core.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieInfoDto(
    @SerializedName("countries")
    val countries: List<CountryDto>,
    @SerializedName("description")
    val description: String,
    @SerializedName("filmLength")
    val filmLength: Int,
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
    @SerializedName("ratingAgeLimits")
    val ratingAgeLimits: String?,
    @SerializedName("ratingKinopoisk")
    val ratingKinopoisk: Double?,
    @SerializedName("webUrl")
    val webUrl: String,
    @SerializedName("year")
    val year: Int,
)

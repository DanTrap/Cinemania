package com.dantrap.cinemania.fintech.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dantrap.cinemania.fintech.core.database.utils.Constants

@Entity(tableName = Constants.Tables.FAVORITE_MOVIES_DETAILS)
data class MovieDetailsEntity(
    @PrimaryKey
    @ColumnInfo(name = Constants.Fields.KINOPOISK_ID)
    val kinopoiskId: Int,

    @ColumnInfo(name = Constants.Fields.GENRES)
    val genres: List<String>,

    @ColumnInfo(name = Constants.Fields.NAME)
    val name: String,

    @ColumnInfo(name = Constants.Fields.POSTER_URL)
    val posterUrl: String,

    @ColumnInfo(name = Constants.Fields.RATING_KINOPOISK)
    val ratingKinopoisk: Double,

    @ColumnInfo(name = Constants.Fields.YEAR)
    val year: Int,

    @ColumnInfo(name = Constants.Fields.COUNTRIES)
    val countries: List<String>,

    @ColumnInfo(name = Constants.Fields.DESCRIPTION)
    val description: String,

    @ColumnInfo(name = Constants.Fields.FILM_LENGTH)
    val filmLength: Int,

    @ColumnInfo(name = Constants.Fields.AGE_LIMITS)
    val ratingAgeLimits: String?,
)

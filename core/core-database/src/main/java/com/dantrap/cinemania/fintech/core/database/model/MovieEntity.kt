package com.dantrap.cinemania.fintech.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dantrap.cinemania.fintech.core.database.utils.Constants

@Entity(tableName = Constants.Tables.FAVORITE_MOVIES)
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(Constants.Fields.ID)
    val id: Int? = null,

    @ColumnInfo(Constants.Fields.KINOPOISK_ID)
    val kinopoiskId: Int,

    @ColumnInfo(Constants.Fields.GENRE)
    val genre: String,

    @ColumnInfo(Constants.Fields.NAME)
    val name: String,

    @ColumnInfo(Constants.Fields.POSTER_URL)
    val posterUrl: String,

    @ColumnInfo(Constants.Fields.POSTER_URL_PREVIEW)
    val posterUrlPreview: String,

    @ColumnInfo(Constants.Fields.RATING_KINOPOISK)
    val ratingKinopoisk: Double,

    @ColumnInfo(Constants.Fields.YEAR)
    val year: Int,
)

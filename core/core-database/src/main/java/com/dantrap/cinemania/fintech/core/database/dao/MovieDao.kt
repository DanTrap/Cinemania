package com.dantrap.cinemania.fintech.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.dantrap.cinemania.fintech.core.database.model.MovieDetailsEntity
import com.dantrap.cinemania.fintech.core.database.model.MovieEntity
import com.dantrap.cinemania.fintech.core.database.utils.Constants.Fields.KINOPOISK_ID
import com.dantrap.cinemania.fintech.core.database.utils.Constants.Tables.FAVORITE_MOVIES
import com.dantrap.cinemania.fintech.core.database.utils.Constants.Tables.FAVORITE_MOVIES_DETAILS
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movies: MovieEntity)

    @Query("SELECT * FROM $FAVORITE_MOVIES")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    @Query("DELETE FROM $FAVORITE_MOVIES WHERE $KINOPOISK_ID = :id")
    suspend fun deleteFavoriteMovie(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetails(movieDetailsEntity: MovieDetailsEntity)

    @Query("SELECT * FROM $FAVORITE_MOVIES_DETAILS WHERE $KINOPOISK_ID = :id")
    fun getFavoriteMovieDetails(id: Int): MovieDetailsEntity

    @Query("DELETE FROM $FAVORITE_MOVIES_DETAILS WHERE $KINOPOISK_ID = :id")
    suspend fun deleteFavoriteMovieDetails(id: Int)

    @Transaction
    suspend fun deleteMovieAndDetails(id: Int) {
        deleteFavoriteMovie(id)
        deleteFavoriteMovieDetails(id)
    }

    @Query("SELECT COUNT() FROM $FAVORITE_MOVIES_DETAILS WHERE $KINOPOISK_ID = :id")
    fun count(id: Int): Int
}

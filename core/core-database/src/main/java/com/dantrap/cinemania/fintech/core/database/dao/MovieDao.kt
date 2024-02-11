package com.dantrap.cinemania.fintech.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dantrap.cinemania.fintech.core.database.model.MovieEntity
import com.dantrap.cinemania.fintech.core.database.utils.Constants.Fields.KINOPOISK_ID
import com.dantrap.cinemania.fintech.core.database.utils.Constants.Tables.FAVORITE_MOVIES
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: MovieEntity)

    @Query("SELECT * FROM $FAVORITE_MOVIES")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    @Query("DELETE FROM $FAVORITE_MOVIES WHERE $KINOPOISK_ID = :id")
    suspend fun deleteFavoriteMovie(id: Int)
}

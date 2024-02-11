package com.dantrap.cinemania.fintech.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dantrap.cinemania.fintech.core.database.dao.MovieDao
import com.dantrap.cinemania.fintech.core.database.model.MovieEntity

@Database(
    version = 1,
    exportSchema = false,
    entities = [MovieEntity::class]
)
abstract class CinemaniaDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {
        const val CINEMANIA_DATABASE = "cinemania.db"
    }
}

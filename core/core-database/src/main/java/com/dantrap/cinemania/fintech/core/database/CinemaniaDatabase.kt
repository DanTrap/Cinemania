package com.dantrap.cinemania.fintech.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dantrap.cinemania.fintech.core.database.converter.ListConverter
import com.dantrap.cinemania.fintech.core.database.dao.MovieDao
import com.dantrap.cinemania.fintech.core.database.model.MovieDetailsEntity
import com.dantrap.cinemania.fintech.core.database.model.MovieEntity

@Database(
    version = 1,
    exportSchema = false,
    entities = [MovieEntity::class, MovieDetailsEntity::class]
)
@TypeConverters(ListConverter::class)
abstract class CinemaniaDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {
        const val CINEMANIA_DATABASE = "cinemania.db"
    }
}

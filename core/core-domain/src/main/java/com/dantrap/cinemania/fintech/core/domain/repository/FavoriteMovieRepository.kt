package com.dantrap.cinemania.fintech.core.domain.repository

import com.dantrap.cinemania.fintech.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface FavoriteMovieRepository {

    fun movies(): Flow<List<Movie>>

    suspend fun save(movie: Movie)

    suspend fun delete(id: Int)
}

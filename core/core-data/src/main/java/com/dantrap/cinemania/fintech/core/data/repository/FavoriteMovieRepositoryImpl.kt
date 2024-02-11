package com.dantrap.cinemania.fintech.core.data.repository

import com.dantrap.cinemania.fintech.core.data.mapper.toDomain
import com.dantrap.cinemania.fintech.core.data.mapper.toEntity
import com.dantrap.cinemania.fintech.core.database.dao.MovieDao
import com.dantrap.cinemania.fintech.core.database.model.MovieEntity
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.domain.repository.FavoriteMovieRepository
import com.dantrap.cinemania.fintech.core.network.api.service.MovieService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class FavoriteMovieRepositoryImpl(
    private val movieDao: MovieDao,
    private val movieService: MovieService,
    private val dispatcherIo: CoroutineDispatcher,
) : FavoriteMovieRepository {

    override fun movies(): Flow<List<Movie>> = movieDao.getFavoriteMovies().map { list ->
        list.map(MovieEntity::toDomain)
    }.flowOn(dispatcherIo)

    override suspend fun save(movie: Movie) {
        withContext(dispatcherIo) {
            movieDao.insertMovie(movie.toEntity())
            try {
                val movieDetailsDto = movieService.getMovieInfo(movie.kinopoiskId)
                movieDao.insertMovieDetails(movieDetailsDto.toEntity())
            } catch (_: Exception) {}
        }
    }

    override suspend fun delete(id: Int) {
        withContext(dispatcherIo) {
            movieDao.deleteMovieAndDetails(id)
        }
    }
}

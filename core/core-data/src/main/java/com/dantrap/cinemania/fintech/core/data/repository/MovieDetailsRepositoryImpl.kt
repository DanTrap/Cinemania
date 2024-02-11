package com.dantrap.cinemania.fintech.core.data.repository

import com.dantrap.cinemania.fintech.core.common.network.Resource
import com.dantrap.cinemania.fintech.core.common.network.httpErrorToResponseError
import com.dantrap.cinemania.fintech.core.common.network.toResponseError
import com.dantrap.cinemania.fintech.core.data.mapper.toDomain
import com.dantrap.cinemania.fintech.core.database.dao.MovieDao
import com.dantrap.cinemania.fintech.core.domain.model.MovieDetails
import com.dantrap.cinemania.fintech.core.domain.repository.MovieDetailsRepository
import com.dantrap.cinemania.fintech.core.network.api.service.MovieService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException

internal class MovieDetailsRepositoryImpl(
    private val movieService: MovieService,
    private val movieDao: MovieDao,
    private val dispatcherIo: CoroutineDispatcher,
) : MovieDetailsRepository {

    override fun movieDetails(kinopoiskId: Int): Flow<Resource<MovieDetails>> = flow {
        emit(Resource.Loading())
        if (movieDao.count(kinopoiskId) > 0) {
            val details = movieDao.getFavoriteMovieDetails(kinopoiskId)
            emit(Resource.Success(details.toDomain()))
        } else {
            try {
                val response = movieService.getMovieInfo(kinopoiskId)
                emit(Resource.Success(response.toDomain()))
            } catch (e: Throwable) {
                when (e) {
                    is IOException -> emit(Resource.Error(e.toResponseError()))
                    is HttpException -> emit(Resource.Error(e.code().httpErrorToResponseError()))
                    else -> emit(Resource.Error(e.toResponseError()))
                }
            }
        }
    }.flowOn(dispatcherIo)
}

package com.dantrap.cinemania.fintech.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.dantrap.cinemania.fintech.core.data.mapper.toDomain
import com.dantrap.cinemania.fintech.core.data.paging.MoviePagingDataSource
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.domain.repository.MovieRepository
import com.dantrap.cinemania.fintech.core.network.api.service.MovieService
import com.dantrap.cinemania.fintech.core.network.model.MovieDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class RemoteMovieRepositoryImpl(
    private val movieService: MovieService,
    private val dispatcherIo: CoroutineDispatcher,
) : MovieRepository {

    override suspend fun movies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 4,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviePagingDataSource(movieService, dispatcherIo) }
        ).flow.map {
            it.map(MovieDto::toDomain)
        }.flowOn(dispatcherIo)
    }
}

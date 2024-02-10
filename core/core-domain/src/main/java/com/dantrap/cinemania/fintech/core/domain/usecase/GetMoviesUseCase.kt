package com.dantrap.cinemania.fintech.core.domain.usecase

import com.dantrap.cinemania.fintech.core.domain.repository.MovieRepository

class GetMoviesUseCase(private val remoteMovieRepository: MovieRepository) {

    suspend operator fun invoke() = remoteMovieRepository.movies()
}

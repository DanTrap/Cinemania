package com.dantrap.cinemania.fintech.core.domain.usecase

import com.dantrap.cinemania.fintech.core.domain.repository.MovieDetailsRepository

class GetMovieDetailsUseCase(private val movieDetailsRepository: MovieDetailsRepository) {

    operator fun invoke(kinopoiskId: Int) = movieDetailsRepository.movieDetails(kinopoiskId)
}

package com.dantrap.cinemania.fintech.core.domain.usecase

import com.dantrap.cinemania.fintech.core.domain.repository.MovieRepository

class SearchMoviesByKeywordUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(keyword: String) = movieRepository.moviesByKeyword(keyword)
}

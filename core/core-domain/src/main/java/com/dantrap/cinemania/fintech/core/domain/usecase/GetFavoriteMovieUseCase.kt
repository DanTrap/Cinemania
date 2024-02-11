package com.dantrap.cinemania.fintech.core.domain.usecase

import com.dantrap.cinemania.fintech.core.domain.repository.FavoriteMovieRepository

class GetFavoriteMovieUseCase(private val favoriteMovieRepository: FavoriteMovieRepository) {
    operator fun invoke() = favoriteMovieRepository.movies()
}

package com.dantrap.cinemania.fintech.core.domain.usecase

import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.domain.repository.FavoriteMovieRepository

class AddMovieToFavoriteUseCase(private val favoriteMovieRepository: FavoriteMovieRepository) {
    suspend operator fun invoke(movie: Movie) = favoriteMovieRepository.save(movie)
}

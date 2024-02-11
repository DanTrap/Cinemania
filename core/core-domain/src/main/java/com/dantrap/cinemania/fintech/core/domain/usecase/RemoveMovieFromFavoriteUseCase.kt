package com.dantrap.cinemania.fintech.core.domain.usecase

import com.dantrap.cinemania.fintech.core.domain.repository.FavoriteMovieRepository

class RemoveMovieFromFavoriteUseCase(private val favoriteMovieRepository: FavoriteMovieRepository) {
    suspend operator fun invoke(id: Int) = favoriteMovieRepository.delete(id)
}

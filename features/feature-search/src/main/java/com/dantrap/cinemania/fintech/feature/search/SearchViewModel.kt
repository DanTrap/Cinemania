package com.dantrap.cinemania.fintech.feature.search

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.domain.usecase.AddMovieToFavoriteUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.GetFavoriteMovieUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.RemoveMovieFromFavoriteUseCase
import com.dantrap.cinemania.fintech.core.domain.usecase.SearchMoviesByKeywordUseCase
import com.dantrap.cinemania.fintech.core.mvi.BaseViewModel
import com.dantrap.cinemania.fintech.feature.search.state.SearchEvent
import com.dantrap.cinemania.fintech.feature.search.state.SearchSideEffect
import com.dantrap.cinemania.fintech.feature.search.state.SearchState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.combine
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class SearchViewModel(
    private val searchMoviesByKeywordUseCase: SearchMoviesByKeywordUseCase,
    private val addMovieToFavoriteUseCase: AddMovieToFavoriteUseCase,
    private val removeMovieFromFavoriteUseCase: RemoveMovieFromFavoriteUseCase,
    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase,
) : BaseViewModel<SearchState, SearchSideEffect, SearchEvent>(initialState = SearchState()) {

    private var job: Job? = null

    override fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnMovieClick -> navigateToMovie(event.id)
            is SearchEvent.OnMovieLongClick -> onLongClick(event.movie)
            is SearchEvent.OnSearch -> searchMovie(event.text)
            is SearchEvent.OnUserInput -> updateQuery(event.text)
        }
    }

    private fun onLongClick(movie: Movie) {
        intent {
            if (movie.isFavorite) {
                removeMovieFromFavoriteUseCase(movie.kinopoiskId)
            } else {
                addMovieToFavoriteUseCase(movie)
            }
        }
    }

    private fun navigateToMovie(id: Int) {
        intent { postSideEffect(SearchSideEffect.NavigateToMovie(id)) }
    }

    private fun searchMovie(text: String) {
        job?.cancel()
        job = intent {
            reduce { state.copy(isLoading = true) }
            val movies = searchMoviesByKeywordUseCase(text.trim()).cachedIn(viewModelScope)
                .combine(getFavoriteMovieUseCase()) { movies, favorites ->
                    movies.map { movie ->
                        if (favorites.map { it.kinopoiskId }.contains(movie.kinopoiskId)) {
                            movie.copy(isFavorite = true)
                        } else {
                            movie.copy(isFavorite = false)
                        }
                    }
                }.cachedIn(viewModelScope)
            reduce { state.copy(movies = movies, isLoading = false) }
        }
    }

    @OptIn(OrbitExperimental::class)
    private fun updateQuery(text: String) {
        blockingIntent { reduce { state.copy(query = text) } }
    }
}
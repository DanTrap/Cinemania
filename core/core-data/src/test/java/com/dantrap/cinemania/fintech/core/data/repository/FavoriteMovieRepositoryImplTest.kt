package com.dantrap.cinemania.fintech.core.data.repository

import com.dantrap.cinemania.fintech.core.data.mapper.toEntity
import com.dantrap.cinemania.fintech.core.database.dao.MovieDao
import com.dantrap.cinemania.fintech.core.database.model.MovieEntity
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import com.dantrap.cinemania.fintech.core.network.api.service.MovieService
import com.dantrap.cinemania.fintech.core.network.model.CountryDto
import com.dantrap.cinemania.fintech.core.network.model.GenreDto
import com.dantrap.cinemania.fintech.core.network.model.MovieDetailsDto
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test

class FavoriteMovieRepositoryImplTest {

    private val movieDao: MovieDao = mockk()
    private val movieService: MovieService = mockk()
    private val dispatcherIo = Dispatchers.Unconfined
    private val favoriteMovieRepository =
        FavoriteMovieRepositoryImpl(movieDao, movieService, dispatcherIo)

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `movie function should work properly`() {
        val movieEntity = mockMovieEntity()
        val movieEntities = listOf(movieEntity)
        coEvery { movieDao.getFavoriteMovies() } returns flowOf(movieEntities)

        runBlocking {
            val movies = favoriteMovieRepository.movies().first()
            assertEquals(1, movies.size)
            assertEquals(movieEntity.kinopoiskId, movies[0].kinopoiskId)
        }
    }

    @Test
    fun `save function should insert movie, fetch movie details and insert movie details`() {
        val movie = mockMovie()
        val movieEntity = movie.toEntity()
        coEvery { movieDao.insertMovie(movieEntity) } returns Unit
        coEvery { movieService.getMovieInfo(123) } returns mockMovieDetailsDto()

        runBlocking {
            favoriteMovieRepository.save(movie)
        }

        coVerify { movieDao.insertMovie(movieEntity) }
        coVerify { movieService.getMovieInfo(123) }
        coVerify { movieDao.insertMovieDetails(any()) }
    }

    @Test
    fun `delete function should delete movie and movie details`() {
        runBlocking {
            val movieId = 1
            coEvery { movieDao.deleteMovieAndDetails(movieId) } returns Unit

            favoriteMovieRepository.delete(movieId)

            coVerify { movieDao.deleteMovieAndDetails(movieId) }
        }
    }

    private fun mockMovie() = Movie(
        kinopoiskId = 123,
        name = "Title",
        genre = "",
        posterUrl = "",
        posterUrlPreview = "",
        ratingKinopoisk = 0.0,
        year = 2022
    )

    private fun mockMovieEntity() = MovieEntity(
        id = 1,
        name = "Title 1",
        kinopoiskId = 123,
        genre = "",
        posterUrl = "",
        posterUrlPreview = "",
        ratingKinopoisk = 0.0,
        year = 2022
    )

    private fun mockMovieDetailsDto() = MovieDetailsDto(
        kinopoiskId = 123,
        countries = listOf(CountryDto("usa")),
        description = "desc",
        filmLength = 140,
        genres = listOf(GenreDto("action")),
        nameOriginal = null,
        nameRu = "",
        posterUrl = "",
        ratingAgeLimits = "",
        ratingKinopoisk = 8.5,
        webUrl = "",
        year = 2023
    )
}

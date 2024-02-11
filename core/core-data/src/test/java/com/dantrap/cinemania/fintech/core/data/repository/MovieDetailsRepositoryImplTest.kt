package com.dantrap.cinemania.fintech.core.data.repository

import com.dantrap.cinemania.fintech.core.common.network.Resource
import com.dantrap.cinemania.fintech.core.database.dao.MovieDao
import com.dantrap.cinemania.fintech.core.database.model.MovieDetailsEntity
import com.dantrap.cinemania.fintech.core.domain.model.MovieDetails
import com.dantrap.cinemania.fintech.core.network.api.service.MovieService
import com.dantrap.cinemania.fintech.core.network.model.CountryDto
import com.dantrap.cinemania.fintech.core.network.model.GenreDto
import com.dantrap.cinemania.fintech.core.network.model.MovieDetailsDto
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class MovieDetailsRepositoryImplTest {

    private val movieDao: MovieDao = mockk()
    private val movieService: MovieService = mockk()
    private val dispatcherIo = Dispatchers.Unconfined
    private val repository = MovieDetailsRepositoryImpl(movieService, movieDao, dispatcherIo)

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `movie details should work properly if database empty`() {
        val movieDetails = mockMovieDetails()
        every { movieDao.count(movieDetails.kinopoiskId) } returns 0
        coEvery { movieService.getMovieInfo(movieDetails.kinopoiskId) } returns mockMovieDetailsDto()

        runBlocking {
            repository.movieDetails(movieDetails.kinopoiskId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> assert(true)
                    is Resource.Success -> assertEquals(movieDetails, resource.data)
                    is Resource.Error -> fail("exception")
                }
            }
        }
    }

    @Test
    fun `movie details should work properly if database not empty`() {
        val movieDetails = mockMovieDetails()
        every { movieDao.count(movieDetails.kinopoiskId) } returns 1
        coEvery { movieDao.getFavoriteMovieDetails(movieDetails.kinopoiskId) } returns mockMovieDetailsEntity()

        runBlocking {
            repository.movieDetails(movieDetails.kinopoiskId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> assert(true)
                    is Resource.Success -> assertEquals(movieDetails, resource.data)
                    is Resource.Error -> fail("exception")
                }
            }
        }
    }

    @Test
    fun `movieDetails should take data from the database if it is already there`() {
        val kinopoiskId = 123
        every { movieDao.count(kinopoiskId) } returns 1
        every { movieDao.getFavoriteMovieDetails(kinopoiskId) } returns mockMovieDetailsEntity()

        runBlocking {
            repository.movieDetails(kinopoiskId).collect()
        }

        coVerify(exactly = 0) { movieService.getMovieInfo(kinopoiskId) }
        coVerify(exactly = 1) { movieDao.getFavoriteMovieDetails(kinopoiskId) }
    }

    @Test
    fun `movieDetails should fetch data from the remote if it is not in the database`() {
        val kinopoiskId = 123
        every { movieDao.count(kinopoiskId) } returns 0
        coEvery { movieService.getMovieInfo(kinopoiskId) } returns mockMovieDetailsDto()

        runBlocking {
            repository.movieDetails(kinopoiskId).collect()
        }

        coVerify(exactly = 1) { movieService.getMovieInfo(kinopoiskId) }
        coVerify(exactly = 0) { movieDao.getFavoriteMovieDetails(kinopoiskId) }
    }

    private fun mockMovieDetailsDto(): MovieDetailsDto = MovieDetailsDto(
        countries = listOf(CountryDto("usa")),
        description = "desc",
        filmLength = 140,
        genres = listOf(GenreDto("action")),
        kinopoiskId = 123,
        nameOriginal = null,
        nameRu = "Барби",
        posterUrl = "url",
        ratingAgeLimits = "age13",
        ratingKinopoisk = 8.5,
        webUrl = "weburl",
        year = 2023
    )

    private fun mockMovieDetailsEntity(): MovieDetailsEntity = MovieDetailsEntity(
        countries = listOf("usa"),
        description = "desc",
        filmLength = 140,
        genres = listOf("action"),
        kinopoiskId = 123,
        name = "Барби",
        posterUrl = "url",
        ratingAgeLimits = "age13",
        ratingKinopoisk = 8.5,
        year = 2023
    )

    private fun mockMovieDetails(): MovieDetails = MovieDetails(
        countries = listOf("usa"),
        description = "desc",
        filmLength = 140,
        genres = listOf("action"),
        kinopoiskId = 123,
        name = "Барби",
        posterUrl = "url",
        ratingAgeLimits = "age13",
        ratingKinopoisk = 8.5,
        year = 2023
    )
}

package com.dantrap.cinemania.fintech.core.network.api.service

import com.dantrap.cinemania.fintech.core.network.model.MovieDetailsDto
import com.dantrap.cinemania.fintech.core.network.model.MovieResponseDto
import com.dantrap.cinemania.fintech.core.network.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET(Constants.Path.MOVIE_COLLECTIONS)
    suspend fun getPopularMovies(
        @Query(Constants.Fields.TYPE) type: String = Constants.POPULAR_MOVIES_TYPE,
        @Query(Constants.Fields.PAGE) page: Int = Constants.DEFAULT_PAGE,
    ): MovieResponseDto

    @GET(Constants.Path.MOVIE_INFO)
    suspend fun getMovieInfo(
        @Path(Constants.Fields.ID) id: Int,
    ): MovieDetailsDto
}

package com.dantrap.cinemania.fintech.core.domain.repository

import com.dantrap.cinemania.fintech.core.common.network.Resource
import com.dantrap.cinemania.fintech.core.domain.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MovieDetailsRepository {

    fun movieDetails(kinopoiskId: Int): Flow<Resource<MovieDetails>>
}

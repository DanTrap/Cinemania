package com.dantrap.cinemania.fintech.core.domain.repository

import androidx.paging.PagingData
import com.dantrap.cinemania.fintech.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun movies(): Flow<PagingData<Movie>>

    suspend fun moviesByKeyword(keyword: String): Flow<PagingData<Movie>>
}

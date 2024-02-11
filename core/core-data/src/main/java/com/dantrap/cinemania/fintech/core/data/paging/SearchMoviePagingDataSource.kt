package com.dantrap.cinemania.fintech.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dantrap.cinemania.fintech.core.network.api.service.MovieService
import com.dantrap.cinemania.fintech.core.network.model.MovieDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

internal class SearchMoviePagingDataSource(
    private val keyword: String,
    private val movieService: MovieService,
    private val dispatcherIo: CoroutineDispatcher,
) : PagingSource<Int, MovieDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> =
        withContext(dispatcherIo) {
            try {
                val pageIndex = params.key ?: 1
                val response = movieService.getMoviesByKeyword(keyword = keyword, page = pageIndex)
                LoadResult.Page(
                    data = response.movies.filter { it.nameRu != null || it.nameOriginal != null },
                    prevKey = null,
                    nextKey = if (
                        response.movies.isEmpty() ||
                        pageIndex == 20 ||
                        pageIndex == response.pagesCount
                    ) {
                        null
                    } else {
                        pageIndex + 1
                    }
                )
            } catch (e: Throwable) {
                e.printStackTrace()
                when (e) {
                    is IOException -> LoadResult.Error(e)
                    is HttpException -> LoadResult.Error(e)
                    else -> LoadResult.Error(e)
                }
            }
        }

    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? = null
}

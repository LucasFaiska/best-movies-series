package com.lfaiska.bestmoviesseries.data.remote.datasource.movie

import com.lfaiska.bestmoviesseries.data.remote.dto.PagedListResponse
import com.lfaiska.bestmoviesseries.data.remote.dto.MovieDetailResponse
import com.lfaiska.bestmoviesseries.data.remote.dto.MovieResponse

interface MovieRemoteDataSource {
    suspend fun getMovies(): PagedListResponse<MovieResponse>
    suspend fun getMovie(movieId: Long): MovieDetailResponse
    suspend fun getSimilarMovies(movieId: Long): PagedListResponse<MovieResponse>
}
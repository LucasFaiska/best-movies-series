package com.lfaiska.bestmoviesseries.data.remote.service

import com.lfaiska.bestmoviesseries.data.remote.dto.PagedListResponse
import com.lfaiska.bestmoviesseries.data.remote.dto.MovieDetailResponse
import com.lfaiska.bestmoviesseries.data.remote.dto.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/movie/popular")
    suspend fun getMovies(): PagedListResponse<MovieResponse>

    @GET("/movie/{movieId}")
    suspend fun getMovie(@Path("movieId") movieId: Long): MovieDetailResponse

    @GET("/movie/{movieId}/similar")
    suspend fun getSimilarMovies(@Path("movieId") movieId: Long): PagedListResponse<MovieResponse>

}
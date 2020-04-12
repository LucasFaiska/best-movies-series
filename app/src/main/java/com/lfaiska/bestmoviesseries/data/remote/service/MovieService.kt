package com.lfaiska.bestmoviesseries.data.remote.service

import com.lfaiska.bestmoviesseries.data.remote.entity.MovieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.MovieListRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/movie/popular")
    suspend fun getMovies(): MovieListRemoteEntity

    @GET("/movie/{movieId}")
    suspend fun getMovie(@Path("movieId") movieId: Long): MovieDetailRemoteEntity

    @GET("/movie/{movieId}/similar")
    suspend fun getSimilarMovies(@Path("movieId") movieId: Long): MovieListRemoteEntity

}
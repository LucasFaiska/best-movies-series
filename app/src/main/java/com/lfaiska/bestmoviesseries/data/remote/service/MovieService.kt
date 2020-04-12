package com.lfaiska.bestmoviesseries.data.remote.service

import com.lfaiska.bestmoviesseries.data.remote.entity.MovieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.MovieListRemoteEntity
import retrofit2.http.GET

interface MovieService {

    @GET("/movie/popular")
    suspend fun getMovies(): MovieListRemoteEntity

    @GET("/movie/{movieId}")
    suspend fun getMovieDetail(): MovieDetailRemoteEntity

    @GET("/movie/{movieId}/similar")
    suspend fun getSimilarSeries(): MovieListRemoteEntity

}
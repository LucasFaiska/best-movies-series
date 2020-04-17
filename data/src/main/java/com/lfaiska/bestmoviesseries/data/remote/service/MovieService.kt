package com.lfaiska.bestmoviesseries.data.remote.service

import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.MovieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.MovieRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/movie/popular")
    suspend fun getMovies(): ListRemoteEntity<MovieRemoteEntity>

    @GET("/movie/{movieId}")
    suspend fun getMovie(@Path("movieId") movieId: Long): MovieDetailRemoteEntity

    @GET("/movie/{movieId}/similar")
    suspend fun getSimilarMovies(@Path("movieId") movieId: Long): ListRemoteEntity<MovieRemoteEntity>

}
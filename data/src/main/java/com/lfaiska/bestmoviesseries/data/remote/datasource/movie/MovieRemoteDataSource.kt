package com.lfaiska.bestmoviesseries.data.remote.datasource.movie

import com.lfaiska.bestmoviesseries.data.remote.entity.MovieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.MovieListRemoteEntity

interface MovieRemoteDataSource {
    suspend fun getMovies() : MovieListRemoteEntity
    suspend fun getMovie(movieId: Long) : MovieDetailRemoteEntity
    suspend fun getSimilarMovies(movieId: Long) : MovieListRemoteEntity
}
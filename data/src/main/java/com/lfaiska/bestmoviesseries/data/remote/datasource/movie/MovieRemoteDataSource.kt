package com.lfaiska.bestmoviesseries.data.remote.datasource.movie

import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.MovieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.MovieRemoteEntity

interface MovieRemoteDataSource {
    suspend fun getMovies(): ListRemoteEntity<MovieRemoteEntity>
    suspend fun getMovie(movieId: Long): MovieDetailRemoteEntity
    suspend fun getSimilarMovies(movieId: Long): ListRemoteEntity<MovieRemoteEntity>
}
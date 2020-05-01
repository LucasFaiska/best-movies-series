package com.lfaiska.bestmoviesseries.data.remote.datasource.movie

import com.lfaiska.bestmoviesseries.data.remote.entity.PagedListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.MovieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.MovieRemoteEntity

interface MovieRemoteDataSource {
    suspend fun getMovies(): PagedListRemoteEntity<MovieRemoteEntity>
    suspend fun getMovie(movieId: Long): MovieDetailRemoteEntity
    suspend fun getSimilarMovies(movieId: Long): PagedListRemoteEntity<MovieRemoteEntity>
}
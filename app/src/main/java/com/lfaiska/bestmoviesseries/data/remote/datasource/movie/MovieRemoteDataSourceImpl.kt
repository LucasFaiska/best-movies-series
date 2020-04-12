package com.lfaiska.bestmoviesseries.data.remote.datasource.movie

import com.lfaiska.bestmoviesseries.data.remote.datasource.base.BaseRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.service.MovieService

class MovieRemoteDataSourceImpl(private val service: MovieService) : MovieRemoteDataSource,
    BaseRemoteDataSource() {

    override suspend fun getMovies() = performRequest { service.getMovies() }

    override suspend fun getMovieDetails(movieId: Long) =
        performRequest { service.getMovieDetail(movieId) }

    override suspend fun getSimilarMovies(movieId: Long) =
        performRequest { service.getSimilarMovies(movieId) }
}
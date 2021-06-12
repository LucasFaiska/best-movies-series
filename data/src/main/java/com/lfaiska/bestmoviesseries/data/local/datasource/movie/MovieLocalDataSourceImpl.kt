package com.lfaiska.bestmoviesseries.data.local.datasource.movie

import com.lfaiska.bestmoviesseries.data.local.dao.MovieDao
import com.lfaiska.bestmoviesseries.data.local.dto.MovieLocalEntity

class MovieLocalDataSourceImpl(private val dao: MovieDao) : MovieLocalDataSource {

    override suspend fun getMovies(): List<MovieLocalEntity> = dao.getMovies()

    override suspend fun saveMovies(movies: List<MovieLocalEntity>) {
        dao.saveMovies(movies)
    }
}
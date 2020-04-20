package com.lfaiska.bestmoviesseries.data.local.datasource.movie

import com.lfaiska.bestmoviesseries.data.local.entity.MovieLocalEntity

interface MovieLocalDataSource {
    suspend fun getMovies(): List<MovieLocalEntity>
    suspend fun saveMovies(movies: List<MovieLocalEntity>)
}
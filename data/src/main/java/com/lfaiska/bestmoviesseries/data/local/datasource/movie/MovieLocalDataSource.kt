package com.lfaiska.bestmoviesseries.data.local.datasource.movie

import com.lfaiska.bestmoviesseries.data.local.dto.MovieLocalEntity

interface MovieLocalDataSource {
    suspend fun getMovies(): List<MovieLocalEntity>
    suspend fun saveMovies(movies: List<MovieLocalEntity>)
}
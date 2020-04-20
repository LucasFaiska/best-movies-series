package com.lfaiska.bestmoviesseries.data.local.datasource.movie

import com.lfaiska.bestmoviesseries.data.local.entity.MovieLocalEntity

interface MovieLocalDataSource {
    fun getMovies(): List<MovieLocalEntity>
    fun saveMovies(movies: List<MovieLocalEntity>)
}
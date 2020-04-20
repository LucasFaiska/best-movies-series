package com.lfaiska.bestmoviesseries.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lfaiska.bestmoviesseries.data.local.entity.MovieLocalEntity

interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getMovies(): List<MovieLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(registers: List<MovieLocalEntity>)
}
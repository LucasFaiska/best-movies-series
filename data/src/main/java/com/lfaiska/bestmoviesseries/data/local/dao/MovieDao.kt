package com.lfaiska.bestmoviesseries.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lfaiska.bestmoviesseries.data.local.dto.MovieLocalEntity

interface MovieDao {
    @Query("SELECT * FROM movies")
    suspend fun getMovies(): List<MovieLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(registers: List<MovieLocalEntity>)
}
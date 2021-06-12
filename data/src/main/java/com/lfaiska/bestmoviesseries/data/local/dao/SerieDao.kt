package com.lfaiska.bestmoviesseries.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lfaiska.bestmoviesseries.data.local.dto.SerieLocalEntity

interface SerieDao {
    @Query("SELECT * FROM serie WHERE language = :language")
    suspend fun getSeries(language: String): List<SerieLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSeries(registers: List<SerieLocalEntity>)

    @Query("SELECT * FROM serie WHERE id = :serieId AND language = :language")
    suspend fun getSerieDetails(serieId: Long, language: String): SerieLocalEntity
}
package com.lfaiska.bestmoviesseries.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity

interface SerieDao {
    @Query("SELECT * FROM series")
    fun getSeries(parameter: Long): List<SerieLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSeries(registers: List<SerieLocalEntity>)
}
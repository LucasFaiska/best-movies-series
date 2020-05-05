package com.lfaiska.bestmoviesseries.data.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lfaiska.bestmoviesseries.data.local.entity.SerieDataLocalEntity
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity

interface SerieDao {
    @Query("SELECT * FROM serie INNER JOIN serie_locale_data ON serie.id = serie_locale_data.serieId AND serie_locale_data.language = :language")
    suspend fun getSeries(language: String): List<SerieLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSeries(registers: List<SerieDataLocalEntity>)
}
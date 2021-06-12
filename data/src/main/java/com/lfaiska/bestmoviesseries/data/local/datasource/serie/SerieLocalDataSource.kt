package com.lfaiska.bestmoviesseries.data.local.datasource.serie

import com.lfaiska.bestmoviesseries.data.local.dto.SerieLocalEntity

interface SerieLocalDataSource {
    suspend fun getSeries(language: String): List<SerieLocalEntity>
    suspend fun saveSeries(series: List<SerieLocalEntity>)
    suspend fun getSerieDetails(serieId: Long, language: String) : SerieLocalEntity
}
package com.lfaiska.bestmoviesseries.data.local.datasource.serie

import com.lfaiska.bestmoviesseries.data.local.entity.SerieDataLocalEntity

interface SerieLocalDataSource {
    suspend fun getSeries(): List<SerieDataLocalEntity>
    suspend fun saveSeries(series: List<SerieDataLocalEntity>)
}
package com.lfaiska.bestmoviesseries.data.local.datasource.serie

import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity

interface SerieLocalDataSource {
    fun getSeries(): List<SerieLocalEntity>
    fun saveSeries(series: List<SerieLocalEntity>)
}
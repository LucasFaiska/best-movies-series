package com.lfaiska.bestmoviesseries.data.local.datasource.serie

import com.lfaiska.bestmoviesseries.data.local.dao.SerieDao
import com.lfaiska.bestmoviesseries.data.local.entity.SerieDataLocalEntity

class SerieLocalDataSourceImpl(private val dao: SerieDao) : SerieLocalDataSource {

    override suspend fun getSeries(): List<SerieDataLocalEntity> = dao.getSeries()

    override suspend fun saveSeries(series: List<SerieDataLocalEntity>) {
        dao.saveSeries(series)
    }
}
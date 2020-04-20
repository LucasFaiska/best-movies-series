package com.lfaiska.bestmoviesseries.data.local.datasource.serie

import com.lfaiska.bestmoviesseries.data.local.dao.SerieDao
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity

class SerieLocalDataSourceImpl(private val dao: SerieDao) : SerieLocalDataSource {

    override suspend fun getSeries(): List<SerieLocalEntity> = dao.getSeries()

    override suspend fun saveSeries(series: List<SerieLocalEntity>) {
        dao.saveSeries(series)
    }
}
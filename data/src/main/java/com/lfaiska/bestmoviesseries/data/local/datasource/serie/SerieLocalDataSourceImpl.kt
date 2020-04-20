package com.lfaiska.bestmoviesseries.data.local.datasource.serie

import com.lfaiska.bestmoviesseries.data.local.dao.MovieDao
import com.lfaiska.bestmoviesseries.data.local.dao.SerieDao
import com.lfaiska.bestmoviesseries.data.local.entity.MovieLocalEntity
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity

class SerieLocalDataSourceImpl(private val dao: SerieDao) : SerieLocalDataSource {

    override fun getSeries(): List<SerieLocalEntity> = dao.getSeries()

    override fun saveSeries(series: List<SerieLocalEntity>) {
        dao.saveSeries(series)
    }
}
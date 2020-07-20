package com.lfaiska.bestmoviesseries.data.local.datasource.serie

import com.lfaiska.bestmoviesseries.data.local.dao.SerieDao
import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity

class SerieLocalDataSourceImpl(private val dao: SerieDao) : SerieLocalDataSource {

    override suspend fun getSeries(language: String): List<SerieLocalEntity> =
        dao.getSeries(language)

    override suspend fun saveSeries(series: List<SerieLocalEntity>) {
        dao.saveSeries(series)
    }

    override suspend fun getSerieDetails(serieId: Long, language: String): SerieLocalEntity =
        dao.getSerieDetails(serieId, language)
}
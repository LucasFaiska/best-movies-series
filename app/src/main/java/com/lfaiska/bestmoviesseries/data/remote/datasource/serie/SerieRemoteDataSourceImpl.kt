package com.lfaiska.bestmoviesseries.data.remote.datasource.serie

import com.lfaiska.bestmoviesseries.data.remote.datasource.base.BaseRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.service.SerieService

class SerieRemoteDataSourceImpl(private val service: SerieService) : SerieRemoteDataSource,
    BaseRemoteDataSource() {

    override suspend fun getSeries() = performRequest { service.getSeries() }

    override suspend fun getSerie(serieId: Long) =
        performRequest { service.getSerie(serieId) }

    override suspend fun getSimilarSerie(serieId: Long) =
        performRequest { service.getSimilarSeries(serieId) }
}
package com.lfaiska.bestmoviesseries.data.remote.datasource.serie

import com.lfaiska.bestmoviesseries.data.remote.datasource.base.BaseRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.service.SerieService

class SerieRemoteDataSourceImpl(private val service: SerieService) : SerieRemoteDataSource,
    BaseRemoteDataSource() {

    override suspend fun getSeries() = performRequest { service.getSeries() }

    override suspend fun getSerieDetails(serieId: Long) =
        performRequest { service.getSerieDetail(serieId) }

    override suspend fun getSimilarSerie(serieId: Long) =
        performRequest { service.getSimilarSeries(serieId) }
}
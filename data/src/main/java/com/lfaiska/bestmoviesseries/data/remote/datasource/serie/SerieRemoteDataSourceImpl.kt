package com.lfaiska.bestmoviesseries.data.remote.datasource.serie

import com.lfaiska.bestmoviesseries.data.remote.datasource.base.BaseRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.service.SerieService

class SerieRemoteDataSourceImpl(private val service: SerieService) : SerieRemoteDataSource, BaseRemoteDataSource() {

    override suspend fun getSeries(page: Int, language: String) = performRequest { service.getSeries(page, language) }

    override suspend fun getSerie(serieId: Long) =
        performRequest { service.getSerie(serieId) }

    override suspend fun getSimilarSeries(serieId: Long) =
        performRequest { service.getSimilarSeries(serieId) }
}
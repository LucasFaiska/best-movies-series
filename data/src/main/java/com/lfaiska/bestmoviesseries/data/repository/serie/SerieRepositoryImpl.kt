package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.mapper.serie.toLocal
import com.lfaiska.bestmoviesseries.data.mapper.serie.toModel
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource

class SerieRepositoryImpl(
    val remote: SerieRemoteDataSource,
    val local: SerieLocalDataSource,
    val connection: Connection
) : SerieRepository {

    override suspend fun getSeries() : List<SerieModel> {
        return if (connection.isAvailable()) {
            val series = remote.getSeries()
            local.saveSeries(series.toLocal())
            series.toModel()
        } else {
            local.getSeries().toModel()
        }
    }
}
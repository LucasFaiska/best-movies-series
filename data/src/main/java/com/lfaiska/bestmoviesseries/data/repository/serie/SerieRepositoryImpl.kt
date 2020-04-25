package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.mapper.SerieMapper
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource

class SerieRepositoryImpl(
    val remote: SerieRemoteDataSource,
    val local: SerieLocalDataSource,
    val connection: Connection,
    val mapper: SerieMapper
) : SerieRepository {

    override suspend fun getSeries() : List<SerieModel> {
        return if (connection.isAvailable()) {
            val series = remote.getSeries()
            local.saveSeries(mapper.mapRemoteToLocal(series))
            mapper.mapRemoteToModel(series)
        } else {
            mapper.mapLocalToModel(local.getSeries())
        }
    }
}
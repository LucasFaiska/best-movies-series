package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.mapper.SerieListMapper
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource
import com.lfaiska.bestmoviesseries.data.repository.base.ListModel

class SerieRepositoryImpl(
    val remote: SerieRemoteDataSource,
    val local: SerieLocalDataSource,
    val connection: Connection,
    val mapper: SerieListMapper
) : SerieRepository {

    override suspend fun getSeries(): ListModel<SerieModel> {
        return if (connection.isAvailable()) {
            val serieList = remote.getSeries()
            local.saveSeries(mapper.mapRemoteToLocal(serieList))
            mapper.mapRemoteToModel(serieList)
        } else {
            mapper.mapLocalToModel(local.getSeries())
        }
    }
}
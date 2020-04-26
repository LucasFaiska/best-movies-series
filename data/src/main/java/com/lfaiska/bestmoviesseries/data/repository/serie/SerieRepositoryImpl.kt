package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.mapper.SerieListMapper
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource

class SerieRepositoryImpl(
    val remote: SerieRemoteDataSource,
    val local: SerieLocalDataSource,
    val connection: Connection,
    val listMapper: SerieListMapper
) : SerieRepository {

    /*override suspend fun getSeries() : List<SerieModel> {
        return if (connection.isAvailable()) {
            val series = remote.getSeries()
            local.saveSeries(listMapper.mapRemoteToLocal(series.results))
            listMapper.mapRemoteToModel(series.results)
        } else {
            listMapper.mapLocalToModel(local.getSeries())
        }
    }*/
}
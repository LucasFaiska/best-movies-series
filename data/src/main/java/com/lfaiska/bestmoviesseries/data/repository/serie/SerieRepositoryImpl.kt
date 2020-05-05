package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.mapper.SerieMapper
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource
import com.lfaiska.bestmoviesseries.data.repository.base.PagedListModel
import java.lang.Exception

class SerieRepositoryImpl(
    val remote: SerieRemoteDataSource,
    val local: SerieLocalDataSource,
    val connection: Connection,
    val mapper: SerieMapper
) : SerieRepository {

    override suspend fun getSeries(page: Int, language: String): PagedListModel<SerieModel> {
        return try {
            if (connection.isAvailable()) {
                val serieList = remote.getSeries(page, language)
                local.saveSeries(mapper.mapRemoteToLocal(serieList))
                mapper.mapRemoteToModel(serieList)
            } else {
                mapper.mapLocalToModel(local.getSeries())
            }
        } catch (exception: Exception) {
            throw SerieRepositoryException(method = "getSeries")
        }
    }
}
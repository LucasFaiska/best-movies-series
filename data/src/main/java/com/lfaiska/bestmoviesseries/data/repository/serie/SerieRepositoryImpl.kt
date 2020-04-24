package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource

class SerieRepositoryImpl(
    val remote: SerieRemoteDataSource,
    val local: SerieLocalDataSource
) : SerieRepository {

    override suspend fun getSeries() {
        TODO("Not yet implemented")
    }
}
package com.lfaiska.bestmoviesseries.data.remote.datasource.serie

import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity

interface SerieRemoteDataSource {
    suspend fun getSeries(): ListRemoteEntity<SerieRemoteEntity>
    suspend fun getSerie(serieId: Long): SerieDetailRemoteEntity
    suspend fun getSimilarSeries(serieId: Long): ListRemoteEntity<SerieRemoteEntity>
}
package com.lfaiska.bestmoviesseries.data.remote.datasource.serie

import com.lfaiska.bestmoviesseries.data.remote.entity.SerieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieListRemoteEntity

interface SerieRemoteDataSource {
    suspend fun getSeries(): SerieListRemoteEntity
    suspend fun getSerieDetails(serieId: Long): SerieDetailRemoteEntity
    suspend fun getSimilarSerie(serieId: Long): SerieListRemoteEntity
}
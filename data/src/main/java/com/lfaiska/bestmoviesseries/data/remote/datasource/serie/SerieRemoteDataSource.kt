package com.lfaiska.bestmoviesseries.data.remote.datasource.serie

import com.lfaiska.bestmoviesseries.data.remote.entity.PagedListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity

interface SerieRemoteDataSource {
    suspend fun getSeries(page: Int, language: String): PagedListRemoteEntity<SerieRemoteEntity>
    suspend fun getSerie(serieId: Long): SerieDetailRemoteEntity
    suspend fun getSimilarSeries(serieId: Long): PagedListRemoteEntity<SerieRemoteEntity>
}
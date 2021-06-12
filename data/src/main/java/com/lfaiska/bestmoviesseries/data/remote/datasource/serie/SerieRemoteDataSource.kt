package com.lfaiska.bestmoviesseries.data.remote.datasource.serie

import com.lfaiska.bestmoviesseries.data.remote.dao.PagedListResponse
import com.lfaiska.bestmoviesseries.data.remote.dao.SerieDetailResponse
import com.lfaiska.bestmoviesseries.data.remote.dao.SerieResponse

interface SerieRemoteDataSource {
    suspend fun getSeries(page: Int, language: String): PagedListResponse<SerieResponse>
    suspend fun getSerieDetails(serieId: Long): SerieDetailResponse
    suspend fun getSimilarSeries(serieId: Long): PagedListResponse<SerieResponse>
}
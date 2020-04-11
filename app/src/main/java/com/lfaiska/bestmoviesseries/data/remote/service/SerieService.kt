package com.lfaiska.bestmoviesseries.data.remote.service

import com.lfaiska.bestmoviesseries.data.remote.entity.SerieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import retrofit2.http.GET

interface SerieService {

    @GET("/tv/popular")
    suspend fun getSeries(): SerieListRemoteEntity

    @GET("/tv/{serieId}")
    suspend fun getSerieDetail(): SerieDetailRemoteEntity

    @GET("/tv/{serieId}/similar")
    suspend fun getSimilarSeries(): SerieListRemoteEntity

}
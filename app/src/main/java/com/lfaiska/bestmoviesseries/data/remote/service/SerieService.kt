package com.lfaiska.bestmoviesseries.data.remote.service

import com.lfaiska.bestmoviesseries.data.remote.entity.SerieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieListRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface SerieService {

    @GET("/tv/popular")
    suspend fun getSeries(): SerieListRemoteEntity

    @GET("/tv/{serieId}")
    suspend fun getSerieDetail(@Path("serieId") serieId: Long): SerieDetailRemoteEntity

    @GET("/tv/{serieId}/similar")
    suspend fun getSimilarSeries(@Path("serieId") serieId: Long): SerieListRemoteEntity

}
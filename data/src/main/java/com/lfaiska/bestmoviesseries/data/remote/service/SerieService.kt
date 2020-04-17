package com.lfaiska.bestmoviesseries.data.remote.service

import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface SerieService {

    @GET("/tv/popular")
    suspend fun getSeries(): ListRemoteEntity<SerieRemoteEntity>

    @GET("/tv/{serieId}")
    suspend fun getSerie(@Path("serieId") serieId: Long): SerieDetailRemoteEntity

    @GET("/tv/{serieId}/similar")
    suspend fun getSimilarSeries(@Path("serieId") serieId: Long): ListRemoteEntity<SerieRemoteEntity>

}
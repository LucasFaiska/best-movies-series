package com.lfaiska.bestmoviesseries.data.remote.service

import com.lfaiska.bestmoviesseries.data.remote.entity.PagedListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieDetailRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SerieService {

    @GET("/tv/popular")
    suspend fun getSeries(@Query("page") page: Int, @Query("value") language: String): PagedListRemoteEntity<SerieRemoteEntity>

    @GET("/tv/{serieId}")
    suspend fun getSerieDetails(@Path("serieId") serieId: Long): SerieDetailRemoteEntity

    @GET("/tv/{serieId}/similar")
    suspend fun getSimilarSeries(@Path("serieId") serieId: Long): PagedListRemoteEntity<SerieRemoteEntity>

}
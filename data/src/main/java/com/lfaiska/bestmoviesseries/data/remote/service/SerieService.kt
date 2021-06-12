package com.lfaiska.bestmoviesseries.data.remote.service

import com.lfaiska.bestmoviesseries.data.remote.dto.PagedListResponse
import com.lfaiska.bestmoviesseries.data.remote.dto.SerieDetailResponse
import com.lfaiska.bestmoviesseries.data.remote.dto.SerieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SerieService {

    @GET("/tv/popular")
    suspend fun getSeries(@Query("page") page: Int, @Query("value") language: String): PagedListResponse<SerieResponse>

    @GET("/tv/{serieId}")
    suspend fun getSerieDetails(@Path("serieId") serieId: Long): SerieDetailResponse

    @GET("/tv/{serieId}/similar")
    suspend fun getSimilarSeries(@Path("serieId") serieId: Long): PagedListResponse<SerieResponse>

}
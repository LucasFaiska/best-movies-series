package com.lfaiska.bestmoviesseries.data.remote.dao

import com.google.gson.annotations.SerializedName
import java.util.*

data class SerieResponse(
    val id: Long,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    val popularity: Double,
    val overview: String,
    val name: String,
    @SerializedName("first_air_date")
    val firstAirDate: String
)
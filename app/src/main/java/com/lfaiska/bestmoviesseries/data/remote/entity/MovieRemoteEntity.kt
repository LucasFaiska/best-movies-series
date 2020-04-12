package com.lfaiska.bestmoviesseries.data.remote.entity

import com.google.gson.annotations.SerializedName
import java.util.*

data class MovieRemoteEntity(
    val id: Long,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    val popularity: Double,
    val overview: String,
    val title: String,
    @SerializedName("release_date")
    val releaseDate: Date
)

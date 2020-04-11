package com.lfaiska.bestmoviesseries.data.remote.entity

import com.google.gson.annotations.SerializedName
import java.util.*

data class SerieDetailRemoteEntity(
    val id: Long,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("created_by")
    val createdBy: List<CreatorRemoteEntity>,
    @SerializedName("first_air_date")
    val firstAirDate: Date,
    val genres: List<GenreRemoteEntity>,
    val name: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("number_of_episodes")
    val numberOfEpisodes: Int,
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int,
    val overview: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)

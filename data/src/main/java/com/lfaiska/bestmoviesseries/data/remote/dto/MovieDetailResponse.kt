package com.lfaiska.bestmoviesseries.data.remote.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class MovieDetailResponse(
    val id: Long,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("created_by")
    val createdBy: List<CreatorResponse>,
    @SerializedName("release_date")
    val releaseDate: Date,
    val genres: List<GenreResponse>,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("number_of_episodes")
    val numberOfEpisodes: Int,
    @SerializedName("number_of_seasons")
    val numberOfSeasons: Int,
    val overview: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    val popularity: Double
)

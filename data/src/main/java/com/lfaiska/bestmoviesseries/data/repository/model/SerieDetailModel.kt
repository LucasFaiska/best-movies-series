package com.lfaiska.bestmoviesseries.data.repository.model

import java.util.Date

data class SerieDetailModel (
    val id: Long,
    val backdropPath: String,
    val createdBy: List<CreatorModel>,
    val firstAirDate: Date,
    val genres: List<GenreModel>,
    val name: String,
    val posterPath: String,
    val numberOfEpisodes: Int,
    val numberOfSeasons: Int,
    val overview: String,
    val voteAverage: Double,
    val popularity: Double
)
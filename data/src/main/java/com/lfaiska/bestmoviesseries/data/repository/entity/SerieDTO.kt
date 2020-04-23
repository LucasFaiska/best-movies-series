package com.lfaiska.bestmoviesseries.data.repository.entity

data class SerieDTO (
    val id: Long,
    val posterPath: String,
    val voteAverage: Double,
    val popularity: Double,
    val overview: String,
    val name: String,
    val firstAirDate: String
)
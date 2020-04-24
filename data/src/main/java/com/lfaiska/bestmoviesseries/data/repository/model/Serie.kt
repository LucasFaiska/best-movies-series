package com.lfaiska.bestmoviesseries.data.repository.model

data class Serie (
    val id: Long,
    val posterPath: String,
    val voteAverage: Double,
    val popularity: Double,
    val overview: String,
    val name: String,
    val firstAirDate: String
)
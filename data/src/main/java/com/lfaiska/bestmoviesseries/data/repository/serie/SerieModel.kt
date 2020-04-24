package com.lfaiska.bestmoviesseries.data.repository.serie

data class SerieModel (
    val id: Long,
    val posterPath: String,
    val voteAverage: Double,
    val popularity: Double,
    val overview: String,
    val name: String,
    val firstAirDate: String,
    val isFavorite: Boolean = false
)
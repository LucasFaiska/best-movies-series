package com.lfaiska.bestmoviesseries.data.mapper

import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.repository.entity.SerieDTO

fun ListRemoteEntity<SerieRemoteEntity>.toLocal() =
    this.results.map { serieRemoteEntity ->
        with(serieRemoteEntity) {
            SerieLocalEntity(
                id,
                posterPath,
                voteAverage,
                popularity,
                overview,
                name,
                firstAirDate
            )
        }
    }

fun ListRemoteEntity<SerieRemoteEntity>.toDTO() =
    this.results.map { serieRemoteEntity ->
        with(serieRemoteEntity) {
            SerieDTO(
                id,
                posterPath,
                voteAverage,
                popularity,
                overview,
                name,
                firstAirDate
            )
        }
    }

fun List<SerieLocalEntity>.toDTO() =
    this.map { serieLocalEntity ->
        with(serieLocalEntity) {
            SerieDTO(
                id,
                posterPath,
                voteAverage,
                popularity,
                overview,
                name,
                firstAirDate
            )
        }
    }
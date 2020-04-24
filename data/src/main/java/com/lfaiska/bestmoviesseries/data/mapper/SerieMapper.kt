package com.lfaiska.bestmoviesseries.data.mapper

import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.repository.serie.SerieModel

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

fun ListRemoteEntity<SerieRemoteEntity>.toModel() =
    this.results.map { serieRemoteEntity ->
        with(serieRemoteEntity) {
            SerieModel(
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

fun List<SerieLocalEntity>.toModel() =
    this.map { serieLocalEntity ->
        with(serieLocalEntity) {
            SerieModel(
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
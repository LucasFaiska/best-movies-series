package com.lfaiska.bestmoviesseries.data.mapper

import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity

fun ListRemoteEntity<SerieRemoteEntity>.toLocal() =
        this.results.map { remoteEntity ->
            with(remoteEntity) {
                SerieLocalEntity(
                    posterPath = posterPath,
                    voteAverage =  voteAverage,
                    popularity =  popularity,
                    overview = overview,
                    name = name,
                    firstAirDate = firstAirDate
                )
            }
        }

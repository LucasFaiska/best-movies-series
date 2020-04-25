package com.lfaiska.bestmoviesseries.data.mapper

import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.repository.serie.SerieModel

class SerieMapper : Mapper<ListRemoteEntity<SerieRemoteEntity>, List<SerieLocalEntity>, List<SerieModel>> {

    override fun mapRemoteToLocal(remote: ListRemoteEntity<SerieRemoteEntity>) =
        remote.results.map { serieRemoteEntity ->
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

    override fun mapRemoteToModel(remote: ListRemoteEntity<SerieRemoteEntity>) =
        remote.results.map { serieRemoteEntity ->
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

    override fun mapLocalToModel(local: List<SerieLocalEntity>) =
        local.map { serieLocalEntity ->
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
}


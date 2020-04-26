package com.lfaiska.bestmoviesseries.data.mapper

import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.ListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.repository.base.ListModel
import com.lfaiska.bestmoviesseries.data.repository.serie.SerieModel

class SerieListMapper :
    Mapper<ListRemoteEntity<SerieRemoteEntity>, List<SerieLocalEntity>, ListModel<SerieModel>> {

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
        with(remote) {
            ListModel(
                page,
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
            )
        }

    override fun mapLocalToModel(local: List<SerieLocalEntity>) =
        ListModel(
            0,
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
        )
}




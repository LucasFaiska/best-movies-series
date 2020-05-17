package com.lfaiska.bestmoviesseries.data.mapper

import com.lfaiska.bestmoviesseries.data.local.entity.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.PagedListRemoteEntity
import com.lfaiska.bestmoviesseries.data.remote.entity.SerieRemoteEntity
import com.lfaiska.bestmoviesseries.data.repository.base.PagedListModel
import com.lfaiska.bestmoviesseries.data.repository.serie.SerieModel

class SerieMapper : Mapper<PagedListRemoteEntity<SerieRemoteEntity>, List<SerieLocalEntity>, PagedListModel<SerieModel>> {

    override fun mapRemoteToLocal(remote: PagedListRemoteEntity<SerieRemoteEntity>, language: String) =
        remote.results.map { serieRemoteEntity ->
            with(serieRemoteEntity) {
                SerieLocalEntity(
                    id,
                    language,
                    posterPath,
                    voteAverage,
                    popularity,
                    overview,
                    name,
                    firstAirDate
                )
            }
        }

    override fun mapRemoteToModel(remote: PagedListRemoteEntity<SerieRemoteEntity>) =
        with(remote) {
            PagedListModel(
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
        PagedListModel(
            0,
            local.map { serieLocalEntity ->
                with(serieLocalEntity) {
                    SerieModel(
                        id,
                        posterImage,
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




package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.local.datasource.serie.SerieLocalDataSource
import com.lfaiska.bestmoviesseries.data.local.dto.SerieLocalEntity
import com.lfaiska.bestmoviesseries.data.remote.connection.Connection
import com.lfaiska.bestmoviesseries.data.remote.datasource.serie.SerieRemoteDataSource
import com.lfaiska.bestmoviesseries.data.remote.dto.PagedListResponse
import com.lfaiska.bestmoviesseries.data.remote.dto.SerieResponse
import com.lfaiska.bestmoviesseries.data.repository.base.PagedListModel
import com.lfaiska.bestmoviesseries.data.repository.model.SerieModel
import java.lang.Exception

class SerieRepositoryImpl(
    val remote: SerieRemoteDataSource,
    val local: SerieLocalDataSource,
    private val connection: Connection
) : SerieRepository {

    override suspend fun getSeries(page: Int, language: String): PagedListModel<SerieModel> {
        return try {
            if (connection.isAvailable()) {
                val seriesList = remote.getSeries(page, language)
                local.saveSeries(mapSeriesListRemoteToLocal(seriesList, language))
                mapSeriesListRemoteToModel(seriesList)
            } else {
                mapSeriesListLocalToModel(local.getSeries(language))
            }
        } catch (exception: Exception) {
            throw SerieRepositoryException(method = "getSeries")
        }
    }

    private fun mapSeriesListRemoteToLocal(
        seriesList: PagedListResponse<SerieResponse>,
        language: String
    ): List<SerieLocalEntity> =
        seriesList.results.map { serieRemoteEntity ->
            with(serieRemoteEntity) {
                SerieLocalEntity(
                    id = id,
                    language = language,
                    posterPath = posterPath,
                    voteAverage = voteAverage,
                    popularity = popularity,
                    overview = overview,
                    name = name,
                    firstAirDate = firstAirDate
                )
            }
        }

    private fun mapSeriesListRemoteToModel(
        seriesList: PagedListResponse<SerieResponse>
    ) = with(seriesList) {
        PagedListModel(
            page,
            seriesList.results.map { serieRemoteEntity ->
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

    private fun mapSeriesListLocalToModel(
        seriesList: List<SerieLocalEntity>
    ) = PagedListModel(
        0,
        seriesList.map { serieLocalEntity ->
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
package com.lfaiska.bestmoviesseries.domain.usecase

import com.lfaiska.bestmoviesseries.data.repository.base.PagedListModel
import com.lfaiska.bestmoviesseries.data.repository.model.SerieModel
import com.lfaiska.bestmoviesseries.data.repository.serie.SerieRepository
import com.lfaiska.bestmoviesseries.domain.model.PagedList
import com.lfaiska.bestmoviesseries.domain.model.Serie

class SerieUseCase(
    private val repository: SerieRepository
) {

    suspend fun getSeries(page: Int, language: String): PagedList<Serie> {
        val seriesPagedList = repository.getSeries(page, language)
        return PagedList(
            page = seriesPagedList.page,
            items = seriesPagedList.items.map { serieModel ->
                Serie(
                    serieModel.id,
                    serieModel.posterPath,
                    serieModel.voteAverage,
                    serieModel.popularity,
                    serieModel.overview,
                    serieModel.name,
                    serieModel.firstAirDate
                )
            }
        )
    }
}

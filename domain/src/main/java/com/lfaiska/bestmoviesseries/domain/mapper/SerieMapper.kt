package com.lfaiska.bestmoviesseries.domain.mapper

import com.lfaiska.bestmoviesseries.data.repository.base.PagedListModel
import com.lfaiska.bestmoviesseries.data.repository.serie.SerieModel
import com.lfaiska.bestmoviesseries.domain.model.PagedList
import com.lfaiska.bestmoviesseries.domain.model.Serie

class SerieMapper() {

    fun mapSeriePagedList(pagedListModel: PagedListModel<SerieModel>) =
        PagedList(
            page = pagedListModel.page,
            items = pagedListModel.items.map { model ->
                Serie(
                    model.id,
                    model.posterPath,
                    model.voteAverage,
                    model.popularity,
                    model.overview,
                    model.name,
                    model.firstAirDate
                )
            }
        )
}
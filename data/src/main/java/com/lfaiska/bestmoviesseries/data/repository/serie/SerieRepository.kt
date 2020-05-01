package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.repository.base.PagedListModel

interface SerieRepository {
    suspend fun getSeries(page: Int) : PagedListModel<SerieModel>
}
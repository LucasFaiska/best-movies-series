package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.repository.base.PagedListModel
import com.lfaiska.bestmoviesseries.data.repository.model.SerieDetailModel
import com.lfaiska.bestmoviesseries.data.repository.model.SerieModel

interface SerieRepository {
    suspend fun getSeries(page: Int, language: String) : PagedListModel<SerieModel>
    //suspend fun getSerieDetails(serieId: Long) : SerieDetailModel
}
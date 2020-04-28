package com.lfaiska.bestmoviesseries.data.repository.serie

import com.lfaiska.bestmoviesseries.data.repository.base.ListModel

interface SerieRepository {
    suspend fun getSeries() : ListModel<SerieModel>
}